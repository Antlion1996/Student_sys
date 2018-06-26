package com.ssh.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Course;
import com.ssh.model.Score;
import com.ssh.model.Teacher;
import com.ssh.service.TeacherService;
import com.ssh.vo.ScoresVo;

/**
 * 
 * 有关教师操作和管理的控制类
 * 
 */
@Component("teacherAction")
@Scope("prototype")
public class TeacherAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Teacher teacher;
	private Course course;
	private Score score;
	private ScoresVo scoresVo;
	private List<Teacher> teachers;
	private Set<Course> courses = new HashSet<Course>();
	private List<ScoresVo> scoresList = new ArrayList<ScoresVo>();
	private TeacherService teacherService;
	private int id;
	private int sid;
	double stuScore;
	private String newPassword;

	@Resource
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public double getStuScore() {
		return stuScore;
	}

	public void setStuScore(double stuScore) {
		this.stuScore = stuScore;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public ScoresVo getScoresVo() {
		return scoresVo;
	}

	public void setScoresVo(ScoresVo scoresVo) {
		this.scoresVo = scoresVo;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public List<ScoresVo> getScoresList() {
		return scoresList;
	}

	public void setScoresList(List<ScoresVo> scoresList) {
		this.scoresList = scoresList;
	}

	/**
	 * 添加教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addTeacher() throws Exception {
		String name = teacher.getCourse().getName();
		System.out.println("------" + teacher.getId()+teacher.getCourse().getName());
		if (teacherService.checkExist(teacher.getId())) {// 验证教工号是否存在
			return "fail";
		}
		teacherService.addTeacher(teacher);
		int i = teacherService.getCid();
		Course course = new Course();
		course.setId(i+1);
		course.setName(name);
		course.setTeacher(teacher);
		i = teacherService.saveCourse(course);
		if(i > 0) {
			teacher.setCourse(course);
			teacherService.updateCid(teacher);
		}
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"添加成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"teacherAction!listTeacher");
		return "addTeacher";
	}

	/**
	 * 获取教师信息列表
	 * 
	 * @return
	 */
	public String listTeacher() {
		this.teachers = this.teacherService.getTeachers();
		return "listTeacher";
	}

	/**
	 * 教师修改个人信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() {
		System.out.println(teacher.getId() + "--" + teacher.getName() + "--"
				+ teacher.getSex() + "--" + teacher.getBirthday() + "--"
				+ teacher.getProfessional() + "--"
				+ teacher.getCourse().getName());
		try {
			teacherService.updateTeacher(teacher);
			ServletActionContext.getRequest().getSession().setAttribute(
					"message", "修改成功");
			ServletActionContext.getRequest().getSession().setAttribute("url",
					"teacher/updateTeacher.jsp");
			ServletActionContext.getRequest().getSession().setAttribute(
					"teacher", teacher);
			return "update";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 管理员修改教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateTeacher() {
		System.out.println(teacher.getId() + "--" + teacher.getName() + "--"
				+ teacher.getSex() + "--" + teacher.getBirthday() + "--"
				+ teacher.getProfessional() + "--"
				+ teacher.getCourse().getName());
		try {
			teacherService.updateTeacher(teacher);
			ServletActionContext.getRequest().getSession().setAttribute(
					"message", "修改成功");
			ServletActionContext.getRequest().getSession().setAttribute("url",
					"/teacherAction!listTeacher.action");
			ServletActionContext.getRequest().getSession().setAttribute(
					"teacher", teacher);
			return "updateTeacher";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 修改页面信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editTeacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		teacher = teacherService.getTeacherById(id);
		return "editTeacher";
	}

	/**
	 * 通过教工号获取教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getTeacherById() throws Exception {
		this.teacher = this.teacherService.getTeacherById(teacher.getId());
		return "getTeacherById";
	}

	/**
	 * 删除教师信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteTeacher() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		teacherService.deleteTeacher(id);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"删除成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"teacherAction!listTeacher");
		return "deleteTeacher";
	}

	/**
	 * 教师获取个人登录密码，用户修改密码时的对比
	 * 
	 * @return
	 */
	public String getPwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		this.teacher = this.teacherService.getTeacherById(id);
		ServletActionContext.getRequest().getSession().setAttribute("teacher",
				teacher);
		return "getPwd";
	}
	
	/**
	 * 管理员获取教师登录密码，用户修改密码时的对比
	 * 
	 * @return
	 */
	public String getTeacherPwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		this.teacher = this.teacherService.getTeacherById(id);
		ServletActionContext.getRequest().getSession().setAttribute("teacher",
				teacher);
		return "getTeacherPwd";
	}

	/**
	 * 教师修改个人登录密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePwd() throws Exception {
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		teacherService.updateTeacherPwd(teacher.getId(), newPassword);
		return "updatePwd";
	}

	/**
	 * 管理员修改教师登录密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateTeacherPwd() throws Exception {
		ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		teacherService.updateTeacherPwd(teacher.getId(), newPassword);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"修改成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"teacherAction!listTeacher");
		return "updateTeacherPwd";
	}

	/**
	 * 查询学生成绩列表
	 * 
	 * @return
	 */
	public String loadStudentScores() {
		try {
			teacher = (Teacher) ServletActionContext.getRequest().getSession()
					.getAttribute("teacher");
			System.out.println("teacher.getId()=" + teacher.getId());
			scoresList = teacherService.loadScores(teacher.getId());
			ServletActionContext.getRequest().getSession().setAttribute(
					"scoresList", scoresList);
			return "loadScores";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 修改页面学生成绩
	 * 
	 * @return
	 */
	public String editStudentScore() {
		try {
			System.out.println("id=" + id);
			score = teacherService.getScoreByid(id);
			ServletActionContext.getRequest().getSession().setAttribute(
					"score", score);
			return "editScore";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 修改学生成绩
	 * 
	 * @return
	 */
	public String updateStudentScore() {
		try {
			score = (Score) ServletActionContext.getRequest().getSession()
					.getAttribute("score");
			System.out.println("id=" + score.getId());
			System.out.println("score=" + stuScore);
			teacherService.updateScoreById(score.getId(), stuScore);
			ServletActionContext.getRequest().getSession().setAttribute(
					"message", "修改成功");
			ServletActionContext.getRequest().getSession().setAttribute("url",
					"teacherAction!loadStudentScores");
			return "updateScore";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 录入学生成绩
	 * 
	 * @return
	 */
	public String addStudentScore() {
		System.out.println("sid=" + sid);
		System.out.println("cid=" + id);
		System.out.println("score=" + stuScore);

		try {
			teacherService.addScore(sid, id, stuScore);
			return "addScore";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}
