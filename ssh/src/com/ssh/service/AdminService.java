package com.ssh.service;

import java.util.List;

import com.ssh.model.Admin;

/**
 * 
 * 有关管理员信息管理的业务逻辑处理的接口
 *
 */
public interface AdminService {
	//获取管理员信息列表
	public List<Admin> getAdmin();
}
