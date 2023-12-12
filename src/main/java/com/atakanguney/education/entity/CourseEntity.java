package com.atakanguney.education.entity;

import com.atakanguney.education.dto.CourseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    public CourseDTO toDto(){
        return CourseDTO.builder()
                .id(this.id)
                .name(this.name)
                .code(this.code)
                .build();
    }

    public void setProperties(CourseEntity updatedCourse) {
        this.code = updatedCourse.getCode();
        this.name = updatedCourse.getName();
    }
}
