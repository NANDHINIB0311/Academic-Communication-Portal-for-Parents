package com.parentlyx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;   // ✅ Corrected
import org.springframework.ui.Model;              // ✅ Missing import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parentlyx.model.Feedback;
import com.parentlyx.model.Student;
import com.parentlyx.repository.FeedbackRepository;
import com.parentlyx.repository.StudentRepository;


@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    // PARENT DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Student> students = studentRepository.findAll(); // later filter by parent
        model.addAttribute("students", students);

        return "parent/dashboard";
    }

    // SEND FEEDBACK
    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "parent/feedback";
    }

    @PostMapping("/saveFeedback")
    public String saveFeedback(@ModelAttribute Feedback feedback) {
        feedbackRepository.save(feedback);
        return "redirect:/parent/dashboard";
    }

    // LANGUAGE TOGGLE (Basic Example)
    @GetMapping("/changeLanguage")
    public String changeLanguage(@RequestParam String lang) {
        return "redirect:/parent/dashboard?lang=" + lang;
    }

}
