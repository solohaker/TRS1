package com.tmzla.training.service;

import java.util.List;

import com.tmzla.training.model.Course;


public interface ICourseService {
	
	public abstract List<Course> findAll();
	public abstract Course findById(Long id);
	public abstract Course save(Course course);
	public abstract void delete(Long id);

}
