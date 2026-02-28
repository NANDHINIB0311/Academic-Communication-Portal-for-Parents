package com.parentlyx.repository;

import com.parentlyx.model.Performance;
import com.parentlyx.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    // Get performance records for one student
    List<Performance> findByStudent(Student student);
}
