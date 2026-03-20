package com.parentlyx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parentlyx.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByParentId(Long parentId);
}