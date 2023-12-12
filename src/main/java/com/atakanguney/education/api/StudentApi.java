package com.atakanguney.education.api;

import com.atakanguney.education.dto.StudentDTO;
import com.atakanguney.education.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class StudentApi {

    @Autowired
    StudentService studentService;

    @GetMapping("student/all")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping(path = "student/")
    public StudentDTO addStudent(@RequestBody StudentDTO student) {
        return studentService.addStudent(student);
    }

    @GetMapping("student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("student/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("student/{studentId}/allocate-course/{courseId}")
    public void allocateCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.allocateCourse(studentId, courseId);
    }

}
