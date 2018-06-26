package com.ssh.vo;

/**
 * 
 * 视图对象类：用于教师查询学生成绩列表
 * 
 */
public class ScoresVo {
	private int id;
	private int studentId;
	private String name;
	private Double score;

	public ScoresVo() {
		// TODO Auto-generated constructor stub
	}

	public ScoresVo(int id, int studentId, String name, Double score) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.name = name;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
