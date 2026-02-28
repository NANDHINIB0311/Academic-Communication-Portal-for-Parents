package com.parentlyx.repository;

import com.parentlyx.model.Student;
import com.parentlyx.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find students by parent
    List<Student> findByParent(User parent);

    // Find student by name
    List<Student> findByName(String name);
}
