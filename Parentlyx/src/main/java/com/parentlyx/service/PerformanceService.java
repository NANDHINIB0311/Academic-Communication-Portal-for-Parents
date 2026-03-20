package com.parentlyx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parentlyx.model.Performance;
import com.parentlyx.repository.PerformanceRepository;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository repository;

    public Performance save(Performance performance) {
        return repository.save(performance);
    }

    public List<Performance> getByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }
}