package com.assigment.assignment2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.assignment2.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{
   
}
