package com.parentlyx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parentlyx.model.Performance;
import com.parentlyx.model.Student;
import com.parentlyx.repository.PerformanceRepository;
import com.parentlyx.repository.StudentRepository;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    // TEACHER DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "teacher/dashboard";
    }

    // ADD NEW STUDENT
    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "teacher/add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/teacher/dashboard";
    }

    // UPDATE STUDENT DETAILS (Attendance, Behaviour, Activity)
    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        model.addAttribute("student", student);
        return "teacher/edit-student";
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/teacher/dashboard";
    }

    // ADD PERFORMANCE (Marks)
    @PostMapping("/addPerformance")
    public String addPerformance(@ModelAttribute Performance performance) {
        performanceRepository.save(performance);
        return "redirect:/teacher/dashboard";
    }

}
