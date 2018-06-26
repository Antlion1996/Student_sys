package com.ssh.dao;

import java.util.List;

import com.ssh.model.Student;

/**
 * 
 * 有关对学生信息CRUD管理的接口
 *
 */
public interface StudentDao {
	//添加学生信息
	public Integer save(Student student);

	//学号是否存在的验证
	public boolean exists(int id);

	//通过id获取学生信息
	public Student getById(int id);

	//获取学生信息列表
	public List<Student> getStudents();

	//修改学生信息
	public void update(Student student);

	//删除学生信息
	public void delete(int id);

	//修改登录密码
	public void updatePwd(int id, String password);

}
