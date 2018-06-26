package com.ssh.dao;

import java.util.List;

import com.ssh.model.Admin;

/**
 * 
 * 管理员信息管理接口
 *
 */
public interface AdminDao {
	//获取管理员信息列表
	public List<Admin> getAdmin();
}
