package com.assigment.assignment2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.assignment2.exception.InvalidIdException;
import com.assigment.assignment2.model.Course;
import com.assigment.assignment2.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
    private CourseRepository courseRepository;

	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
		}

	public Course getSingleCourse(int id) throws InvalidIdException{
 		Optional<Course> optional =  courseRepository.findById(id);
 		if(optional == null)
 			throw new InvalidIdException("ID given is Invalid...");
 		return optional.get();
 	}
}
	
