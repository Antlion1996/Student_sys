package com.ssh.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.model.Admin;
import com.ssh.service.AdminService;

/**
 * 
 * 有关管理员的控制类，用于控制查询管理员信息的页面跳转
 *
 */
@Component("adminAction")
public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Admin> admin;
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}

	/**
	 * 查询管理员信息
	 * @return 用于控制页面跳转
	 */
	@Override
	public String execute() throws Exception {
		this.admin = this.adminService.getAdmin();
		return SUCCESS;
	}

}
