package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.models.Student;
import com.examly.springapp.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Boolean addStudent(Student student) {
        try {
            studentRepo.save(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
