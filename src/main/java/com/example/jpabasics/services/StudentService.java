package com.example.jpabasics.services;

import com.example.jpabasics.models.Student;
import com.example.jpabasics.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {

        studentRepository.save(student);

        return "Student added successfully";
    }

    public Student getStudentById(Integer id) {

        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public String deleteStudentById(Integer id) {

        studentRepository.deleteById(id);

        return "Student deleted successfully";
    }

    public String deleteAllStudents() {

        studentRepository.deleteAll();

        return "Deleted all students successfully";
    }

    public String updateStudentNameById(Integer id, String name) {

        // 1. get student
        // 2. update name
        // 3. then put it back

        Student student = studentRepository.findById(id).get();

        if (!student.equals(null)) {

            // update student name
            student.setName(name);

            // put it back
            studentRepository.save(student);

            return "update student's name successfully";
        }

        return "Student not found";
    }

//    public List<Student> getAllStudentsOfAge(Integer age) {
//
//            return studentRepository.
//    }
}
