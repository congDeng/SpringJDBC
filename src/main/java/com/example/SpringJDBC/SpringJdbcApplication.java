package com.example.SpringJDBC;

import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJdbcApplication.class, args);

		Student student = applicationContext.getBean(Student.class);
		student.setRollNo(100);
		student.setName("Curry");
		student.setMarks(99);

		StudentService studentService = applicationContext.getBean(StudentService.class);
		studentService.addStudent(student);

		System.out.println(studentService.getAllStudents());


	}

}
