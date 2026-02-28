package com.parentlyx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parentlyx.model.Feedback;
import com.parentlyx.model.User;
import com.parentlyx.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Save feedback
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get feedback by parent
    public List<Feedback> getFeedbackByParent(User parent) {
        return feedbackRepository.findByParent(parent);
    }

    // Delete feedback
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
