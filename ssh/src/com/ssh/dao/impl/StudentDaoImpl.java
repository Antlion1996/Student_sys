package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Component;

import com.ssh.dao.StudentDao;
import com.ssh.model.Student;

/**
 * 
 * 有关对学生信息CRUD管理的Dao处理类
 *
 */
@Component("studentDao")
public class StudentDaoImpl extends SuperDao<Student> implements StudentDao {

	public StudentDaoImpl() {
		super(Student.class);
	}
/*
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/

	//添加学生信息
	public Integer save(Student student){
		try {
			return super.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	//删除学生信息
	public void delete(int id) {
//		hibernateTemplate.delete(hibernateTemplate.get(Student.class, id));
		Student student = new Student(id);
		try {
			super.delete(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//通过id获取学生信息
	public Student getById(int id) {
		StringBuffer buffer  = new StringBuffer();
		buffer.append("from Student s where s.id=");
		buffer.append(id);
		try {
			return super.find(buffer.toString()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//获取学生信息列表
	public List<Student> getStudents() {
		try {
			return super.findAll("Student");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//修改学生信息
	public void update(Student student) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update student s set s.birthday='");
		buffer.append(student.getBirthday());
		buffer.append("',s.clazz='");
		buffer.append(student.getClazz());
		buffer.append("',s.name='");
		buffer.append(student.getName());
		buffer.append("',s.sex='");
		buffer.append(student.getSex());
		buffer.append("' where s.Id=");
		buffer.append(student.getId());
		this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(buffer.toString()).executeUpdate();
//		hibernateTemplate.update(student);
	}

	//学号是否存在的验证
	public boolean exists(int id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Student s where s.id=");
		buffer.append(id);
		List<Student> students = null;
		try {
			students = super.find(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (students != null && students.size() > 0) {
			return true;
		}
		return false;
	}

	//修改登录密码
	public void updatePwd(int id, String password) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update Student s set s.password='");
		buffer.append(password);
		buffer.append("' where s.id=");
		buffer.append(id);
		super.getHibernateTemplate().bulkUpdate(buffer.toString());
	}
}
