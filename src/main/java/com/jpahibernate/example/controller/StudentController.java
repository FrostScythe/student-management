package com.jpahibernate.example.controller;

import com.jpahibernate.example.model.Student;
import com.jpahibernate.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(Student studentRequest){
        String response =studentService.addStudent(studentRequest);
        return response;
    }
}
