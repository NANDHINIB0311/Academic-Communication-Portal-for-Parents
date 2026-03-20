package com.parentlyx.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parentlyx.model.Parent;
import com.parentlyx.service.ParentService;

@RestController
@RequestMapping("/api/parents")
@CrossOrigin(origins = "*")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public Parent addParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }
}