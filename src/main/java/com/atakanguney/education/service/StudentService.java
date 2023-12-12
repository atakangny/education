package com.atakanguney.education.service;

import com.atakanguney.education.dto.StudentDTO;
import com.atakanguney.education.entity.CourseEntity;
import com.atakanguney.education.entity.StudentEntity;
import com.atakanguney.education.repository.CourseRepository;
import com.atakanguney.education.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO createUser(StudentDTO user) throws Exception{
        if (user == null) {
            throw new Exception("User can not be null");
        }
        if (user.getId() != null) {
            throw new Exception("User already exists");
        }
        StudentEntity requestStudentEntity = modelMapper.map(user, StudentEntity.class);
        StudentEntity studentEntity = studentRepository.save(requestStudentEntity);
        return studentEntity.toDto();
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentEntity::toDto).collect(Collectors.toList());
    }

    public StudentDTO addStudent(StudentDTO student) {
        StudentEntity studentEntity = modelMapper.map(student, StudentEntity.class);
        return studentRepository.save(studentEntity).toDto();
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Student not found")).toDto();
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Optional<StudentEntity> existingCourseOptional = studentRepository.findById(id);
        if (existingCourseOptional.isEmpty()) {
            throw new EntityNotFoundException("Student not found");
        }
        StudentEntity existingStudent =  existingCourseOptional.get();

        StudentEntity updateStudent = modelMapper.map(studentDTO, StudentEntity.class);
        existingStudent.setProperties(updateStudent);
        return studentRepository.save(existingStudent).toDto();
    }

    public void deleteStudent(Long id) {
        Optional<StudentEntity> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isEmpty()) {
            throw new EntityNotFoundException("Can not delete non-existent student");
        }
        studentRepository.delete(existingStudentOptional.get());
    }

    public void allocateCourse(Long studentId, Long courseId) {
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Non-existing student can not allocate"));
        CourseEntity course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Non-existing course can not be allocated"));

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
