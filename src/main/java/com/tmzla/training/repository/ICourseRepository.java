package com.tmzla.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmzla.training.model.Course;

@Repository("courseRepository")
public interface ICourseRepository extends JpaRepository<Course, Long> {

}
