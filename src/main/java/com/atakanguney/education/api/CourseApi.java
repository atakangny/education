package com.atakanguney.education.api;

import com.atakanguney.education.dto.CourseDTO;
import com.atakanguney.education.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class CourseApi {

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/course/all")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/course/")
    public CourseDTO addCourse(@RequestBody CourseDTO course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/course/{id}")
    public CourseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/course/{id}")
    public CourseDTO updateCourse(@PathVariable Long id, @RequestBody CourseDTO updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

}
