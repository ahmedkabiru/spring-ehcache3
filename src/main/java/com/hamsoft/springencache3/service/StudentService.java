package com.hamsoft.springencache3.service;

import com.hamsoft.springencache3.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created By kabiruahmed on Jan 2019
 */

public interface StudentService {


    void addStudent(Student student);

    List<Student> getAllStudent();

    Optional<Student> getStudentById(long id);

    void deleteStudent(long id);

    void updateStudent(Student student);



}
