package com.example.projectlibrary.service;

import com.example.projectlibrary.entity.Student;
import com.example.projectlibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        Student result = new Student();
        result.setId(student.getId());
        result.setName(student.getName());
        return studentRepository.save(result);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateById(Long id, Student student) {
        Student result = studentRepository.findById(id).orElse(null);
        result.setName(student.getName());
        return studentRepository.save(result);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }
}
