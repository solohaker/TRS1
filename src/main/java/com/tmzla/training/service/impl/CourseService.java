package com.tmzla.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmzla.training.model.Course;
import com.tmzla.training.repository.ICourseRepository;
import com.tmzla.training.service.ICourseService;

@Service("courseService")
public class CourseService implements ICourseService {

	
	@Autowired
	ICourseRepository courseRepository;
	
	
	@Override
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
	@Override
	public Course findById(Long id) {
	Optional<Course>oc= courseRepository.findById(id);
	return oc.orElse(null);
	}
	
	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	@Override
	public void delete(Long id) {
		courseRepository.deleteById(id);
	}
	
	
	
	
}

