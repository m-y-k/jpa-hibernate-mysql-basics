package com.example.jpabasics.controllers;

import com.example.jpabasics.services.StudentService;
import com.example.jpabasics.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    // API - 1 ---> add a student
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    // API - 2 ---> get a student by its Id
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        return studentService.getStudentById(id);
    }

    // API - 3 ---> get all the students
    @GetMapping("/get-all")
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    // API - 4 ---> delete a student by Id
    @DeleteMapping("/delete")
    public String deleteStudentById(@RequestParam("id") Integer id) {

        return studentService.deleteStudentById(id);
    }

    // API - 5 ---> delete all students
    @DeleteMapping("/delete-all")
    public String deleteAllStudents() {

        return studentService.deleteAllStudents();
    }

    // API - 6 ---> update a student's name by taking Id
    @PutMapping("/update-name/{id}/{name}")
    public String updateStudentNameById(@PathVariable Integer id,
                                        @PathVariable String name) {

        return studentService.updateStudentNameById(id, name);
    }

    // API - 7 ---> find all the students of age 20
//    @GetMapping(value = "/get-all-age-{age}")
//    public List<Student> getAllStudentsOfAge(@PathVariable Integer age) {
//
//        return studentService.getAllStudentsOfAge(age);
//    }

}
