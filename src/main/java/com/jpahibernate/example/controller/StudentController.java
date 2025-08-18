package com.jpahibernate.example.controller;

import com.jpahibernate.example.model.Student;
import com.jpahibernate.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student studentRequest){
        String response =studentService.addStudent(studentRequest);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student= studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudentS(){
        List<Student> studentList =studentService.getAllStudent();
        return studentList;
    }

    @GetMapping("/count")
    public String countStudent(){
        String response =studentService.countStudent();
        return response;
    }

    @PutMapping("/updatePut/{id}")
    public String  updateStudentUsingPut(@PathVariable int id, @RequestBody Student newStudentRequest){
        String response=studentService.updateStudentinPut(id,newStudentRequest);
        return response;
    }

    //@RequestParm - only requesting that particular parameter(takes in the form of request parameter query)
    @PatchMapping ("/updatePatch/{id}")
    public String  updateStudentUsingPatch(@PathVariable int id, @RequestParam String newEmail){
        String response=studentService.updateStudentinPatch(id,newEmail);
        return response;
    }
}