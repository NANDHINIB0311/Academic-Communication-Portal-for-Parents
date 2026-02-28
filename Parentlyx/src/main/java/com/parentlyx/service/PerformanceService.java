package com.parentlyx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parentlyx.model.Performance;
import com.parentlyx.model.Student;
import com.parentlyx.repository.PerformanceRepository;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    // Save performance
    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    // Get performance by student
    public List<Performance> getPerformanceByStudent(Student student) {
        return performanceRepository.findByStudent(student);
    }

    // Delete performance
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
}
