package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ssh.dao.AdminDao;
import com.ssh.model.Admin;
import com.ssh.service.AdminService;

/**
 * 
 * 有关管理员信息管理的业务处理类
 *
 */
@Component("adminerService")
public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Resource
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<Admin> getAdmin() {
		return adminDao.getAdmin();
	}

}
