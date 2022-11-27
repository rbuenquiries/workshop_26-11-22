package com.rbu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	List<Student> studentlist = new ArrayList<>();
	List<Course> courselist = new ArrayList<>();
	
	private Date date;
	
	
	

	@RequestMapping(value = "/createStudent", method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		studentlist.add(student);
		System.out.println(student);
		return student;
	}

	@RequestMapping(value = "/createCourse", method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course course) {
		if (course.getCoursename().isEmpty()) {
			course=Course.builder().courseid(1).coursename("core java").duration("3 mnt").build();
		}
		courselist.add(course);
		System.out.println(course);
		return course;
	}
}
