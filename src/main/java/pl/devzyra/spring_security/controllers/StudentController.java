package pl.devzyra.spring_security.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.devzyra.spring_security.model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
     Student.builder().id(1).studentName("John Wick").build(),
     Student.builder().id(2).studentName("Rocky Balboa").build(),
     Student.builder().id(3).studentName("Sam Knight").build()
    );

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return STUDENTS.stream()
                .filter(s -> studentId.equals(s.getId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("Student -> " + studentId + "does not exist"));

    }


}
