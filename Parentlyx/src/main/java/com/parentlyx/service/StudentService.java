package com.parentlyx.service;

import com.parentlyx.model.Student;
import com.parentlyx.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection (BEST PRACTICE)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getByParent(Long parentId) {
        return studentRepository.findByParentId(parentId);
    }
}