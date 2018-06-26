package com.ssh.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "course", catalog = "studentdb")
public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private String name;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);
	private Set<Score> scores = new HashSet<Score>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Teacher teacher, String name, Set<Teacher> teachers,
			Set<Score> scores) {
		this.teacher = teacher;
		this.name = name;
		this.teachers = teachers;
		this.scores = scores;
	}

	// Property accessors
	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)*/
	@GeneratedValue(generator="cen")
	@GenericGenerator(name="cen",strategy="assigned")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Score> getScores() {
		return this.scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

}