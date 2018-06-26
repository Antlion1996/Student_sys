package com.ssh.dao.impl;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ssh.dao.LoginDao;
import com.ssh.model.Admin;
import com.ssh.model.Student;
import com.ssh.model.Teacher;

/**
 * 
 * 登录验证的DAO处理类
 * 
 */
@Component("loginDao")
public class LoginDaoImpl implements LoginDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 打开Session
	public Session getSession() {
		return sessionFactory.openSession();
	}

	// 学生登录验证
	public Student checkStudentLogin(String name, String password) {
		Transaction tx = null;// 初始化事务
		Student student = new Student();
		String hql = "from Student s where s.id=? and s.password=? ";
		try {
			tx = getSession().beginTransaction();
			Query query = getSession().createQuery(hql);
			query.setParameter(0, Integer.valueOf(name));
			query.setParameter(1, password);
			student = (Student) query.uniqueResult();
			tx.commit();// 提交事务
			return student;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 教师登录验证
	public Teacher checkTeacherLogin(String name, String password) {
		Transaction tx = null;// 初始化事务
		Teacher teacher = new Teacher();
		String hql = "from Teacher t where t.id=? and t.password=? ";
		try {
			tx = getSession().beginTransaction();
			Query query = getSession().createQuery(hql);
			query.setParameter(0, Integer.valueOf(name));
			query.setParameter(1, password);
			teacher = (Teacher) query.uniqueResult();
			tx.commit();// 提交事务
			return teacher;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 管理员登录验证
	public Admin checkAdminerLogin(String username, String password) {
		Transaction tx = null;// 初始化事务
		Admin admin = new Admin();
		String hql = "from Admin a where a.username=? and a.password=? ";
		try {
			tx = getSession().beginTransaction();
			Query query = getSession().createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
			admin = (Admin) query.uniqueResult();
			tx.commit();// 提交事务
			return admin;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

}
