package com.ssh.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Admin;
import com.ssh.model.Student;
import com.ssh.model.Teacher;
import com.ssh.service.LoginService;

/**
 * 登录验证控制类：包括学生、教师、管理员的登录验证
 * 
 */
@Component("loginAction")
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int type;
	private String username;
	private String password;
	private Student student;
	private Teacher teacher;
	private Admin admin;
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	@Resource
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	/**
	 * 学生、教师、管理员登录验证
	 */
	@Override
	public String execute() throws Exception {
		System.out.println("username=" + username);
		System.out.println("password=" + password);
		System.out.println("type=" + type);

		if (type == 0) {// 学生登录验证
			//int id = Integer.parseInt(username);
			student = loginService.checkStudentLogin(username, password);
			if (student != null) {
				ServletActionContext.getRequest().getSession().setAttribute(
						"student", student);
				return "student";
			} else
				return INPUT;
		} else if (type == 1) {// 教师登录验证
			//int id = Integer.parseInt(username);
			teacher = loginService.checkTeacherLogin(username, password);
			if (teacher != null) {
				ServletActionContext.getRequest().getSession().setAttribute(
						"teacher", teacher);
				return "teacher";
			} else
				return INPUT;
		} else {// 管理员登录验证
			admin = loginService.checkAdminLogin(username, password);
			if (admin != null) {
				ServletActionContext.getRequest().getSession().setAttribute(
						"admin", admin);
				return "admin";
			} else
				return INPUT;
		}
	}
}
