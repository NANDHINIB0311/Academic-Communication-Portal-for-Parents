package com.parentlyx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parentlyx.model.Feedback;
import com.parentlyx.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public List<Feedback> getByParent(Long parentId) {
        return repository.findByParentId(parentId);
    }
}