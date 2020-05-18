package com.tmzla.training.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmzla.training.model.Student;


@Repository("studentRepository")
public interface IStudentRepository extends JpaRepository<Student, Long>{

}
