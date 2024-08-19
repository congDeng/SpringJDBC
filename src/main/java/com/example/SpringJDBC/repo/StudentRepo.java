package com.example.SpringJDBC.repo;

import com.example.SpringJDBC.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public void save(Student student) {
        System.out.println("student saved");
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
