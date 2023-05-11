package com.example.jpabasics.repositories;

import com.example.jpabasics.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByAge(Integer age);

    public List<Student> findByAgeAndMarks(Integer age, Integer marks);

    public List<Student> findByAgeOrMarks(Integer age, Integer marks);


    @Query(value = "SELECT * FROM student_data WHERE student_data.age > :age", nativeQuery = true)
    public List<Student> getAllStudentsGreaterThanAge(Integer age);
}
