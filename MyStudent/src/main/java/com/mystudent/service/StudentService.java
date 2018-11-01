package com.mystudent.service;

import java.util.List;
import java.util.Optional;

import com.mystudent.model.Student;

public interface StudentService {
	
	Iterable<Student> findAll();

    List<Student> search(String q);

    Optional<Student> findOne(Integer id);
    
    void save(Student contact);

    void delete(Integer id);
    
}
