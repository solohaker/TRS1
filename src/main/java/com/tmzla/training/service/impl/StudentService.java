package com.tmzla.training.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmzla.training.repository.IStudentRepository;
import com.tmzla.training.service.IStudentService;
import com.tmzla.training.model.Student;

@Service("studentService")
public class StudentService implements IStudentService{
	@Autowired
	
	IStudentRepository studentRepository;
	
	
	@Override
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	@Override
	public Student findById(Long id) {
		Optional<Student>os=studentRepository.findById(id);
		return os.orElse(null);
	}
@Override
public  Student save(Student student) {
	return studentRepository.save(student);
	
}

@Override
public void  delete(Long id) {
	studentRepository.deleteById(id);
}

}
