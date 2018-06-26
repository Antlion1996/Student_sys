package com.ssh.service;

import java.util.List;

import com.ssh.model.Course;
import com.ssh.model.Score;
import com.ssh.model.Teacher;
import com.ssh.vo.ScoresVo;

/**
 * 
 * 有关教师管理操作的接口：包括老师对学生成绩录入、查询、修改操作，管理员对教师的CRUD操作
 * 
 */
public interface TeacherService {
	// 添加教师信息
	public Integer addTeacher(Teacher teacher);

	// 删除教师信息
	public void deleteTeacher(int id);

	// 通过教工号获取教师信息
	public Teacher getTeacherById(int id);

	// 修改教师信息
	public void updateTeacher(Teacher teacher);

	// 通过教工号验证是否存在该教师的信息
	public boolean checkExist(int id);

	// 获取教师信息列表
	public List<Teacher> getTeachers();

	// 通过教师id查询学生成绩列表
	public List<Score> getScoreByTeacherId(int tid);

	// 通过学生id查询学生成绩
	public Score getScoreByid(int id);

	// 修改学生成绩
	public void updateScoreById(int id, double score);

	// 获取视图对象所需信息
	public List<ScoresVo> loadScores(int id);

	// 录入学生成绩
	public void addScore(int sid, int cid, double score);

	// 修改教师登录密码
	public void updateTeacherPwd(int id, String password);
	
	//获取cid
	public Integer getCid();
	
	//保存课程
	public int saveCourse(Course course);
	
	//修改cid
	public void updateCid(Teacher teacher);

}
