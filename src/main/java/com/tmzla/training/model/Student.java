package com.tmzla.training.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table(name="STUDENTS")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="student_id")
	private Long studentId;
	private String firstName;
	private String lastName;
		
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	//@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST) 
	
	@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", 
	scope = Course.class)
	
	@JoinTable(name="student_course", joinColumns= {@JoinColumn(name="student_id",
	referencedColumnName="studentId")},
	inverseJoinColumns= {@JoinColumn(name="course_id", referencedColumnName="courseId")})
	private List<Course> courses;

	public Student(Long studentId, String firstName, String lastName, List<Course> courses) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}

	public Student() {
		super();
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	
	
	
}
