package com.ssh.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Score;
import com.ssh.model.Student;
import com.ssh.service.StudentService;
import com.ssh.vo.StudentScoresVo;

/**
 * 
 * 有关学生操作和管理的控制类
 * 
 */
@Component("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Student student;
	private List<Student> students;
	private StudentService studentService;
	private Set<Score> scores = new HashSet<Score>();
	private String newPassword;
	private StudentScoresVo scoresVo;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public StudentScoresVo getScoresVo() {
		return scoresVo;
	}

	public void setScoresVo(StudentScoresVo scoresVo) {
		this.scoresVo = scoresVo;
	}

	/**
	 * 添加学生信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addStudent() throws Exception {
		System.out.println("------" + student.getId());
		if (studentService.exists(student)) {
			return "fail";
		}
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"添加成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"/studentAction!listStudent");
		studentService.add(student);
		return "addStudent";
	}

	/**
	 * 获取学生信息列表
	 * 
	 * @return
	 */
	public String listStudent() {
		this.students = this.studentService.getStudents();
		return "listStudent";
	}

	/**
	 * 通过id获取学生信息
	 * 
	 * @return
	 */
	public String getStudentById() {
		this.student = this.studentService.getById(student.getId());
		ServletActionContext.getRequest().getSession().setAttribute("student",
				student);
		return "getStudentById";
	}

	/**
	 * 学生个人成绩查询
	 * 
	 * @return
	 */
	public String getScore() {
		Student student = (Student) ServletActionContext.getRequest()
				.getSession().getAttribute("student");
		System.out.println(student.getId());
		try {
			scoresVo = studentService.getStudentScores(student.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletActionContext.getRequest().getSession().setAttribute("scoresVo",
				scoresVo);
		return "getScore";
	}

	/**
	 * 学生修改个人信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {

		studentService.update(student);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"修改成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"student/updateStudent.jsp");
		ServletActionContext.getRequest().getSession().setAttribute("student",
				student);
		return "update";
	}

	/**
	 * 管理员修改学生信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateStudent() throws Exception {

		studentService.update(student);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"修改成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"/studentAction!listStudent.action");
		ServletActionContext.getRequest().getSession().setAttribute("student",
				student);
		return "updateStudent";
	}

	/**
	 * 修改学生页面信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editStudent() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id + "----------");
		student = studentService.getById(id);
		return "editStudent";
	}

	/**
	 * 删除学生信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteStudent() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		studentService.delete(id);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"删除成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"/studentAction!listStudent");
		return "deleteStudent";
	}

	/**
	 * 学生获取个人登录密码，用于修改密码时对比
	 * 
	 * @return
	 */
	public String getPwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		this.student = this.studentService.getById(id);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"修改成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"/studentAction!listStudent");
		ServletActionContext.getRequest().getSession().setAttribute("student",
				student);
		return "getPwd";
	}

	/**
	 * 获取学生登录密码，用于修改密码时对比
	 * 
	 * @return
	 */
	public String getStudentPwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		this.student = this.studentService.getById(id);
		ServletActionContext.getRequest().getSession().setAttribute("message",
				"修改成功");
		ServletActionContext.getRequest().getSession().setAttribute("url",
				"/studentAction!listStudent");
		ServletActionContext.getRequest().getSession().setAttribute("student",
				student);
		return "getStudentPwd";
	}

	/**
	 * 学生修改个人登录密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePwd() throws Exception {
		studentService.updatePwd(student.getId(), newPassword);
		return "updatePwd";
	}

	/**
	 * 管理修改学生登录密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateStudentPwd() throws Exception {
		studentService.updatePwd(student.getId(), newPassword);
		return "updateStudentPwd";
	}
}
