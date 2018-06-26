package com.ssh.dao;

import java.util.List;

import com.ssh.model.Course;
import com.ssh.model.Teacher;

public interface TeacherDao {

	// 添加教师信息
	public Integer addTeacher(Teacher teacher);

	// 删除教师信息
	public void deleteTeacher(int id);

	// 通过教工号获取教师信息
	public Teacher getTeacherById(int id);

	// 修改教师信息
	public void updateTeacher(Teacher teacher);

	// 通过教工号验证是否存在该教师的信息
	public boolean checkExist(int id);

	// 获取教师信息列表
	public List<Teacher> getTeachers();

	// 修改教师登录密码
	public void updateTeacherPwd(int id, String password);

	//获取cid
	public Integer getCid();
	
	//保存课程
	public int saveCourse(Course course);
	
	//修改cid
	public void updateCid(Teacher teacher);
}
