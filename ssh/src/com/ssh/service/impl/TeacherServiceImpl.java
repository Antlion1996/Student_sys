package com.ssh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssh.dao.ScoreDao;
import com.ssh.dao.TeacherDao;
import com.ssh.model.Course;
import com.ssh.model.Score;
import com.ssh.model.Teacher;
import com.ssh.service.TeacherService;
import com.ssh.vo.ScoresVo;

/**
 * 
 * 有关教师管理操作的业务处理类：包括老师对学生成绩录入、查询、修改操作，管理员对教师的CRUD操作
 * 
 */
@Component("teacherService")
public class TeacherServiceImpl implements TeacherService {
	private TeacherDao teacherDao;
	private ScoreDao scoreDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	@Resource
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	@Resource
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	//保存课程
	public int saveCourse(Course course) {
		return teacherDao.saveCourse(course);
	}

	//修改cid
	public void updateCid(Teacher teacher) {
		teacherDao.updateCid(teacher);
	}
	
	//获取cid
	public Integer getCid() {
		return teacherDao.getCid();
	}

	// 录入学生成绩
	public void addScore(int sid, int cid, double score) {
		this.scoreDao.addScore(sid, cid, score);

	}

	// 添加教师信息
	public Integer addTeacher(Teacher teacher) {
		return teacherDao.addTeacher(teacher);
	}

	// 通过教工号验证是否存在该教师的信息
	public boolean checkExist(int id) {
		return teacherDao.checkExist(id);
	}

	// 删除教师信息
	public void deleteTeacher(int id) {
		teacherDao.deleteTeacher(id);
	}

	// 通过学生id查询学生成绩
	public Score getScoreByid(int id) {
		return this.scoreDao.getScoreByid(id);
	}

	// 通过教师id查询学生成绩列表
	public List<Score> getScoreByTeacherId(int tid) {
		return this.scoreDao.getScoreByTeacherId(tid);
	}

	// 通过教工号获取教师信息
	public Teacher getTeacherById(int id) {
		return this.teacherDao.getTeacherById(id);
	}

	// 获取教师信息列表
	public List<Teacher> getTeachers() {
		return this.teacherDao.getTeachers();
	}

	// 获取视图对象所需信息
	public List<ScoresVo> loadScores(int id) {
		List<ScoresVo> list = new ArrayList<ScoresVo>();
		List<Score> scores = scoreDao.getScoreByTeacherId(id);
		ScoresVo scoresVo;
		for (Score score : scores) {
			scoresVo = new ScoresVo(score.getId(), score.getStudent().getId(),
					score.getStudent().getName(), score.getScore());
			System.out.println(score.getId() + "--"
					+ score.getStudent().getId() + "--"
					+ score.getStudent().getName() + "--" + score.getScore());
			list.add(scoresVo);
		}
		return list;
	}

	// 修改学生成绩
	public void updateScoreById(int id, double score) {
		this.scoreDao.updateScoreById(id, score);
	}

	// 修改教师信息
	public void updateTeacher(Teacher teacher) {
		this.teacherDao.updateTeacher(teacher);
	}

	// 修改教师登录密码
	public void updateTeacherPwd(int id, String password) {
		this.teacherDao.updateTeacherPwd(id, password);
	}

}
