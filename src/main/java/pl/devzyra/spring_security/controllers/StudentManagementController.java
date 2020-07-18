package pl.devzyra.spring_security.controllers;

import org.springframework.web.bind.annotation.*;
import pl.devzyra.spring_security.model.Student;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {


    private static final List<Student> STUDENTS = Arrays.asList(
            Student.builder().id(1).studentName("John Wick").build(),
            Student.builder().id(2).studentName("Rocky Balboa").build(),
            Student.builder().id(3).studentName("Sam Knight").build()
    );

    @GetMapping
    public List<Student> getAllStudents(){
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println("[POST] student");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        System.out.println("[DELETE] student");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student){
        System.out.println("[UPDATE] student");
        System.out.println(String.format("%s -> %s", studentId,student));
    }

}
