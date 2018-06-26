package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssh.dao.StudentDao;
import com.ssh.model.Student;
import com.ssh.service.StudentService;
import com.ssh.vo.StudentScoresVo;

/**
 * 
 * 有关学生信息管理的业务处理类
 * 
 */
@Component("studentService")
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	// 添加学生信息
	public Integer add(Student student) {
		return studentDao.save(student);
	}

	// 学号是否存在的验证
	public boolean exists(Student student) {
		return studentDao.exists(student.getId());
	}

	// 删除学生信息
	public void delete(int id) {
		studentDao.delete(id);
	}

	// 获取学生信息列表
	public List<Student> getStudents() {
		return this.studentDao.getStudents();
	}

	// 通过id获取学生信息
	public Student getById(int id) {
		return this.studentDao.getById(id);
	}

	// 修改学生信息
	public void update(Student student) {
		studentDao.update(student);
	}

	// 修改登录密码
	public void updatePwd(int id, String password) {
		studentDao.updatePwd(id, password);
	}

	// 获取学生查询个人成绩的视图信息
	public StudentScoresVo getStudentScores(int id) {
		Student student = studentDao.getById(id);
		StudentScoresVo scoresVo = new StudentScoresVo();
		scoresVo.setId(student.getId());
		scoresVo.setName(student.getName());
		scoresVo.setScores(student.getScores());
		System.out.println(scoresVo.getScores().size()
				+ "________________________");
		return scoresVo;
	}

}
