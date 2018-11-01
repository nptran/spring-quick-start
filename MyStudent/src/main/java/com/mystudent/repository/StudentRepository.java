package com.mystudent.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mystudent.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByNameContaining(String q);

}