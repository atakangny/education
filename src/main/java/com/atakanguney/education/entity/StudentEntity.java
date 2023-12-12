package com.atakanguney.education.entity;

import com.atakanguney.education.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "STUDENT")
public class StudentEntity {

    @Id
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses;

    public StudentDTO toDto(){
        return StudentDTO.builder()
                .id(this.id)
                .name(this.name)
                .phone(this.phone)
                .email(this.email)
                .address(this.address)
                .build();
    }
}
