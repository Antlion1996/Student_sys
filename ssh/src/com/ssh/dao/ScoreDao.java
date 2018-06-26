package com.ssh.dao;

import java.util.List;

import com.ssh.model.Score;
/**
 * 
 * 有关对学生成绩操作的接口：包括录入、查询、修改学生成绩
 *
 */
public interface ScoreDao {

	// 录入学生成绩
	public void addScore(int sid, int cid, double score);

	// 通过学生id查询学生成绩
	public Score getScoreByid(Integer id);

	// 通过教师id查询学生成绩列表
	public List<Score> getScoreByTeacherId(Integer id);

	// 修改学生成绩
	public void updateScoreById(int id, double score);

}
