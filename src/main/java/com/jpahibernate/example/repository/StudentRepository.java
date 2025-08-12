package com.jpahibernate.example.repository;

import com.jpahibernate.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it performs the database operations and it is the data layer
public interface StudentRepository extends JpaRepository<Student,Integer> {

}