package com.assigment.assignment2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.assignment2.dto.MessageResponseDto;
import com.assigment.assignment2.exception.InvalidIdException;
import com.assigment.assignment2.model.Course;
import com.assigment.assignment2.service.CourseService;

@RestController
public class CourseController {
 
	@Autowired
 	private CourseService courseService;
	
	@Autowired
	private MessageResponseDto messageDto;
	
	@PostMapping("/api/course/add")
 	public Course addCourse(@RequestBody Course course) {
 		return courseService.addCourse(course);
 	}
	
	@GetMapping("/api/course/getall")
	public List<Course> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	@GetMapping("/api/course/one/{id}") 
	public ResponseEntity<?> getSingleCourse(@PathVariable int id) {
	    try {
	        Course course = courseService.getSingleCourse(id);
	        return ResponseEntity.ok(course); 
	    } catch (InvalidIdException e) {
	        messageDto.setBody(e.getMessage());
	        messageDto.setStatusCode(400);
	        return ResponseEntity.status(400).body(messageDto); 
	    } 
	}
}
