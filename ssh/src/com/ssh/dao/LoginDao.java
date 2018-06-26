package com.ssh.dao;

import com.ssh.model.Admin;
import com.ssh.model.Student;
import com.ssh.model.Teacher;

/**
 * 
 * 学生、教师、管理员登录验证的接口
 *
 */
public interface LoginDao {

	public Student checkStudentLogin(String name, String password);// 学生登录验证

	public Teacher checkTeacherLogin(String name, String password);// 教师登录验证

	public Admin checkAdminerLogin(String username, String password);// 管理员登录验证
}
