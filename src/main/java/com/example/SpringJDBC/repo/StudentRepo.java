package com.example.SpringJDBC.repo;

import com.example.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "INSERT INTO student (rollno, name, marks) VALUES (?, ?, ?)";
        int updatedCount = this.jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(updatedCount + " rows affected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) -> {
            Student student = new Student();
            student.setRollNo(resultSet.getInt("rollno"));
            student.setName(resultSet.getString("name"));
            student.setMarks(resultSet.getInt("marks"));
            return student;
        });
    }
}
