package com.atakanguney.education.service;

import com.atakanguney.education.dto.CourseDTO;
import com.atakanguney.education.entity.CourseEntity;
import com.atakanguney.education.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(CourseEntity::toDto).collect(Collectors.toList());
    }

    public CourseDTO addCourse(CourseDTO courseDTO){
        CourseEntity courseEntity = modelMapper.map(courseDTO, CourseEntity.class);
        return courseRepository.save(courseEntity).toDto();
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO){
        Optional<CourseEntity> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isEmpty()) {
            throw new EntityNotFoundException("Course not found");
        }
        CourseEntity existingCourse = existingCourseOptional.get();

        CourseEntity updatedCourse = modelMapper.map(courseDTO, CourseEntity.class);
        existingCourse.setProperties(updatedCourse);
        return courseRepository.save(existingCourse).toDto();
    }

    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Course not found")).toDto();
    }

    public void deleteCourse(Long id) {
        Optional<CourseEntity> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isEmpty()) {
            throw new EntityNotFoundException("Can not delete non-existent course");
        }
        courseRepository.delete(existingCourseOptional.get());
    }


}
