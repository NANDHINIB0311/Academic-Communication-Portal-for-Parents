package com.parentlyx.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parentlyx.model.Student;
import com.parentlyx.model.User;
import com.parentlyx.repository.StudentRepository;
import com.parentlyx.repository.UserRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        long studentCount = studentRepository.count();
        long teacherCount = userRepository.countByRole("TEACHER");
        long parentCount = userRepository.countByRole("PARENT");
        model.addAttribute("studentCount", studentCount);
        model.addAttribute("teacherCount", teacherCount);
        model.addAttribute("parentCount", parentCount);

        return "admin/dashboard";
    }

    // VIEW ALL STUDENTS
    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "admin/students";
    }

    // ADD STUDENT FORM
    @GetMapping("/addStudent")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "admin/add-student";
    }

    // SAVE STUDENT
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/admin/students";
    }

    // ADD TEACHER OR PARENT
    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/admin/dashboard";
    }

}
