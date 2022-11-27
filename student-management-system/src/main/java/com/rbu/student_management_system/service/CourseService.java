package com.rbu.student_management_system.service;

import com.rbu.student_management_system.domain.Course;
import com.rbu.student_management_system.model.CourseDTO;
import com.rbu.student_management_system.repos.CourseRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDTO> findAll() {
        return courseRepository.findAll(Sort.by("id"))
                .stream()
                .map(course -> mapToDTO(course, new CourseDTO()))
                .collect(Collectors.toList());
    }

    public CourseDTO get(final Long id) {
        return courseRepository.findById(id)
                .map(course -> mapToDTO(course, new CourseDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CourseDTO courseDTO) {
        final Course course = new Course();
        mapToEntity(courseDTO, course);
        return courseRepository.save(course).getId();
    }

    public void update(final Long id, final CourseDTO courseDTO) {
        final Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(courseDTO, course);
        courseRepository.save(course);
    }

    public void delete(final Long id) {
        courseRepository.deleteById(id);
    }

    private CourseDTO mapToDTO(final Course course, final CourseDTO courseDTO) {
        courseDTO.setId(course.getId());
        courseDTO.setCoursename(course.getCoursename());
        courseDTO.setDuration(course.getDuration());
        return courseDTO;
    }

    private Course mapToEntity(final CourseDTO courseDTO, final Course course) {
        course.setCoursename(courseDTO.getCoursename());
        course.setDuration(courseDTO.getDuration());
        return course;
    }

}
