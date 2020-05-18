package com.tmzla.training.service;

import java.util.List;

import com.tmzla.training.model.Student;
public interface IStudentService {
	public abstract List<Student> findAll();
	public abstract Student findById(Long id);
	public abstract Student save(Student student);
	public abstract void delete(Long id);

}
