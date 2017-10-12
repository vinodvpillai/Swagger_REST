package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student findStudentById(final int id) {
		return studentRepository.findOne(id);
	}

	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}

	public Student saveStudent(final Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudentById(final int id) {
		studentRepository.delete(id);
	}
}
