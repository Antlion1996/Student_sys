package com.ssh.vo;

import java.util.Set;

import com.ssh.model.Score;

/**
 * 
 * 学生查询个人成绩的视图对象类
 * 
 */
public class StudentScoresVo {
	private Integer id;
	private String name;
	private Set<Score> scores;

	public StudentScoresVo() {

	}

	public StudentScoresVo(Integer id, String name, Set<Score> scores) {
		this.id = id;
		this.name = name;
		this.scores = scores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}
