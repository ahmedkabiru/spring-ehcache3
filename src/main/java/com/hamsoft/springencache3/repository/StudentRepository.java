package com.hamsoft.springencache3.repository;

import com.hamsoft.springencache3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By kabiruahmed on Jan 2019
 */

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
