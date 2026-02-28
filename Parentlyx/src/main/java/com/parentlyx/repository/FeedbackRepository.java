package com.parentlyx.repository;

import com.parentlyx.model.Feedback;
import com.parentlyx.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Get feedback by parent
    List<Feedback> findByParent(User parent);
}
