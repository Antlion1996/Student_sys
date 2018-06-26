package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ssh.dao.AdminDao;
import com.ssh.model.Admin;

/**
 * 
 * 管理员信息管理的Dao处理类
 *
 */
@Component("adminerDao")
public class AdminDaoImpl implements AdminDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//获取管理员信息列表
	@SuppressWarnings("unchecked")
	public List<Admin> getAdmin() {
		return (List<Admin>) hibernateTemplate.find("from Admin");
	}

}
