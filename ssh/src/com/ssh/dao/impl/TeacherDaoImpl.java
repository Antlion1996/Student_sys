package com.ssh.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.ssh.dao.TeacherDao;
import com.ssh.model.Course;
import com.ssh.model.Teacher;

/**
 * �йؽ�ʦ��Dao�����ࣺ ������ʦ��¼��֤����¼�����޸ĺ͹���Ա�Խ�ʦ��Ϣ��CRUD����
 * 
 */
@Component("teacherDao")
public class TeacherDaoImpl extends SuperDao<Teacher> implements TeacherDao {
	public TeacherDaoImpl() {
		super(Teacher.class);
	}

	// ͨ���̹��Ż�ȡ��ʦ��Ϣ
	public Teacher getTeacherById(int id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Teacher t where t.id=");
		buffer.append(id);
		try {
			return super.find(buffer.toString()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ͨ���̹�����֤�Ƿ���ڸý�ʦ����Ϣ
	public boolean checkExist(int id) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("from Teacher t where t.id=");
		buffer.append(id);
		List<Teacher> teachers = null;
		try {
			teachers = this.find(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (teachers != null && teachers.size() > 0) {
			return true;
		}
		return false;
	}

	// ɾ����ʦ��Ϣ
	public void deleteTeacher(int id) {
		Teacher teacher = new Teacher(id);
		try {
			super.delete(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//��ȡcid
	public Integer getCid() {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		String hql="select max(c.id) from Course c";
		int i = (Integer) session.createQuery(hql).uniqueResult();
		session.close();
		return i;
	}
	
	//����γ�
	public int saveCourse(Course course) {
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(course);
		transaction.commit();
		session.close();
		return course.getId();
	}

	// �����ʦ��Ϣ
	public Integer addTeacher(Teacher teacher) {
		try {
			String cname = teacher.getCourse().getName();
			Course course = new Course();
			course.setId(1);
			teacher.setCourse(course);
			int i = super.save(teacher);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public void updateCid(Teacher teacher) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update teacher t set t.course_id='");
		buffer.append(teacher.getCourse().getId());
		buffer.append("' where t.Id=");
		buffer.append(teacher.getId());
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		int i = session.createSQLQuery(buffer.toString()).executeUpdate();
		session.close();
	}

	// ��ȡ��ʦ��Ϣ�б�
	public List<Teacher> getTeachers() {
		try {
			return super.findAll("Teacher");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// �޸Ľ�ʦ��Ϣ
	public void updateTeacher(Teacher teacher) {
		System.out.println(":::"+teacher.getId() + "--" + teacher.getName() + "--"
				+ teacher.getSex() + "--" + teacher.getBirthday() + "--"
				+ teacher.getProfessional() + "--"
				+ teacher.getCourse().getName());
		StringBuffer buffer = new StringBuffer();
		buffer.append("update teacher t set t.birthday='");
		buffer.append(teacher.getBirthday());
		buffer.append("',t.professional='");
		buffer.append(teacher.getProfessional());
		buffer.append("',t.name='");
		buffer.append(teacher.getName());
		buffer.append("',t.sex='");
		buffer.append(teacher.getSex());
		buffer.append("' where t.Id=");
		buffer.append(teacher.getId());
		this.getHibernateTemplate().getSessionFactory().openSession()
				.createSQLQuery(buffer.toString()).executeUpdate();

	}

	// �޸Ľ�ʦ��¼����
	public void updateTeacherPwd(int id, String password) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("update Teacher t set t.password='");
		buffer.append(password);
		buffer.append("' where t.id=");
		buffer.append(id);
		super.getHibernateTemplate().bulkUpdate(buffer.toString());
	}

}
