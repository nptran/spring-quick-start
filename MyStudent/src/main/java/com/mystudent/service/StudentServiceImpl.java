package com.mystudent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudent.model.Student;
import com.mystudent.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> search(String q) {
        return studentRepository.findByNameContaining(q);
    }

    @Override
    public Optional<Student> findOne(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student contact) {
    	studentRepository.save(contact);
    }

    @Override
    public void delete(Integer id) {
    	studentRepository.deleteById(id);
    }

}
