package com.parentlyx.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.parentlyx.model.Performance;
import com.parentlyx.service.PerformanceService;
@RestController
@RequestMapping("/api/teacher") 
@CrossOrigin(origins = "*")
    public class TeacherController {
        @Autowired
        private PerformanceService performanceService;
        @PostMapping("/addPerformance")
        public Performance addPerformance(@RequestBody Performance performance){
        return performanceService.save(performance);
        } 
                     
        @GetMapping("/studentPerformance/{studentId}")
         public Object getPerformance(@PathVariable Long studentId) {
            return performanceService.getByStudent(studentId); 
    } 
}