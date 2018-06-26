package com.ssh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssh.dao.LoginDao;
import com.ssh.model.Admin;
import com.ssh.model.Student;
import com.ssh.model.Teacher;
import com.ssh.service.LoginService;

/**
 * 
 * 登录验证的业务处理类
 *
 */
@Component("loginService")
public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	@Resource
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	// 学生登录验证
	public Student checkStudentLogin(String name, String password) {
		return loginDao.checkStudentLogin(name, password);
	}

	// 教师登录验证
	public Teacher checkTeacherLogin(String name, String password) {
		return loginDao.checkTeacherLogin(name, password);
	}

	// 管理员登录验证
	public Admin checkAdminLogin(String username, String password) {
		return loginDao.checkAdminerLogin(username, password);
	}

}
