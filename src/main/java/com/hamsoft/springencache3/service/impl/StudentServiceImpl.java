package com.hamsoft.springencache3.service.impl;

import com.hamsoft.springencache3.model.Student;
import com.hamsoft.springencache3.repository.StudentRepository;
import com.hamsoft.springencache3.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created By kabiruahmed on Jan 2019
 */

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames={"student-cache"})
public class StudentServiceImpl implements StudentService {

    final StudentRepository studentRepository;

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    @CacheEvict(beforeInvocation = true)
    @Cacheable
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    @CacheEvict(beforeInvocation = true)
    @Cacheable
    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteStudent(long id) {
         studentRepository.deleteById(id);
    }


    @Override
    @Transactional
    public void updateStudent(Student student) {
         studentRepository.save(student);
    }
}
