package com.jpahibernate.example.service;


import com.jpahibernate.example.model.Student;
import com.jpahibernate.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Student> getAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        return studentList;
    }

    public String countStudent(){
        long totalCount= studentRepository.count();
        return "Total student present are: "+totalCount;
    }

    public String updateStudentinPut(int id, Student newStudentRequest){
        Student existingStudent = getStudentById(id);
        if(existingStudent != null){
            newStudentRequest.setId(id); // Set the ID explicitly
            studentRepository.save(newStudentRequest);
            return "Student updated successfully";
        } else {
            return "Student not found, hence cannot be updated";
        }
    }
}