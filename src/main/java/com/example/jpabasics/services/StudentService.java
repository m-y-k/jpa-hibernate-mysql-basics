package com.example.jpabasics.services;

import com.example.jpabasics.enums.Department;
import com.example.jpabasics.models.LibraryCard;
import com.example.jpabasics.models.Student;
import com.example.jpabasics.repositories.CardRepository;
import com.example.jpabasics.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CardRepository cardRepository;



    public String addStudent(Student student, Department department) {

        // create a new card and set its required parameters
        LibraryCard card = new LibraryCard();
        card.setDepartment(department);

        card.setStudent(student); // first make child to parent relation
        cardRepository.save(card);
        student.setLibraryCard(card); // then make parent to child relation

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

    public List<Student> getAllStudentsOfAge(Integer age) {

            return studentRepository.findByAge(age);
    }


    public List<String> getAllStudentsOfAgeAndMarks(Integer age, Integer marks) {

        List<Student> studentList = studentRepository.findByAgeAndMarks(age, marks);

        return studentObjectToStringNameList(studentList);
    }

    public List<String> getAllStudentsOfAgeOrMarks(Integer age, Integer marks) {

        List<Student> studentList = studentRepository.findByAgeOrMarks(age, marks);

        return studentObjectToStringNameList(studentList);
    }

    public List<String> getAllStudentsGreaterThanAge(Integer age) {

        List<Student> studentList = studentRepository.getAllStudentsGreaterThanAge(age);

        return studentObjectToStringNameList(studentList);
    }

    public List<String> studentObjectToStringNameList(List<Student> studentList) {

        List<String> students = new ArrayList<>();

        for (Student student : studentList) {
            students.add(student.getName());
        }

        return students;
    }
}
