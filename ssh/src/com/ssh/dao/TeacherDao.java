package com.ssh.dao;

import java.util.List;

import com.ssh.model.Course;
import com.ssh.model.Teacher;

public interface TeacherDao {

	// ��ӽ�ʦ��Ϣ
	public Integer addTeacher(Teacher teacher);

	// ɾ����ʦ��Ϣ
	public void deleteTeacher(int id);

	// ͨ���̹��Ż�ȡ��ʦ��Ϣ
	public Teacher getTeacherById(int id);

	// �޸Ľ�ʦ��Ϣ
	public void updateTeacher(Teacher teacher);

	// ͨ���̹�����֤�Ƿ���ڸý�ʦ����Ϣ
	public boolean checkExist(int id);

	// ��ȡ��ʦ��Ϣ�б�
	public List<Teacher> getTeachers();

	// �޸Ľ�ʦ��¼����
	public void updateTeacherPwd(int id, String password);

	//��ȡcid
	public Integer getCid();
	
	//����γ�
	public int saveCourse(Course course);
	
	//�޸�cid
	public void updateCid(Teacher teacher);
}
