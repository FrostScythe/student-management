package com.jpahibernate.example.service;


import com.jpahibernate.example.model.Student;
import com.jpahibernate.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // it contains the business logic
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student studentRequest){
        studentRepository.save(studentRequest);
        return "Student saved successfully";
    }

    public Student getStudentById(int id){
       Optional<Student> studentOptional= studentRepository.findById(id);
       if(studentOptional.isPresent()){
           return studentOptional.get();
       }else{
           return null;
       }
    }
}