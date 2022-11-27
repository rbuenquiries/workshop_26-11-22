package com.rbu.student_management_system.repos;

import com.rbu.student_management_system.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
