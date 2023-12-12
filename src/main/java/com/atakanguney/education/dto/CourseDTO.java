package com.atakanguney.education.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    private String code;

}
