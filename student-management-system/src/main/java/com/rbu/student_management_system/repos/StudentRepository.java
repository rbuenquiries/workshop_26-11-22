package com.rbu.student_management_system.repos;

import com.rbu.student_management_system.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
