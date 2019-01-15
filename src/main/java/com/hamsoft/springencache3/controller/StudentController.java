package com.hamsoft.springencache3.controller;

import com.hamsoft.springencache3.model.Student;
import com.hamsoft.springencache3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created By kabiruahmed on Jan 2019
 */

@RequestMapping("api/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

    final StudentService studentService;


    @GetMapping
    public List<Student> index(){

        return studentService.getAllStudent();
    }


    @PostMapping
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        System.out.println("Student Name"+ student.getName());
        System.out.println("Student Sex"+ student.getSex());
        studentService.addStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(student.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

        Optional<Student> studentOptional = studentService.getStudentById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);
        studentService.addStudent(student);
        return ResponseEntity.noContent().build();
    }



    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }






}
