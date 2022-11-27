package com.rbu.student_management_system.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String coursename;

    @NotNull
    @Size(max = 255)
    private String duration;

}
