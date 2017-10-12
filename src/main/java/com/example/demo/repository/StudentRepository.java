package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

/**
 * StudentRepository - All Student CRUD Operations
 * @author VPillai
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
