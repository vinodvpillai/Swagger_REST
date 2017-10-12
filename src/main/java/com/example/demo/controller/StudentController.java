package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@Api(value = "/students", consumes = "application/json", produces = "application/json")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{id}")
	@ApiOperation(value = "Get Student by ID", notes = "Single Student object will be returned base on the Student ID", response = Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Student not found") })
	public Student getStudent(
			@ApiParam(value = "ID to be searched", required = true) @PathVariable int id) {
		return studentService.findStudentById(id);
	}

	@GetMapping("/students")
	@ApiOperation(value = "Get All Students", notes = "List of Student object will be returned", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid URI"),
			@ApiResponse(code = 404, message = "Students  not found") })
	public List<Student> getAllStudent() {
		return studentService.findAllStudent();
	}

	@PostMapping("/students")
	@ApiOperation(value = "Add new Student", notes = "Saved Student object will be returned", response = Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid Student Object"),
			@ApiResponse(code = 404, message = "Student Object can't be inserted") })
	public Student addStudent(
			@ApiParam(value = "Student to be inserted", required = true) @RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@PutMapping("/students/{id}")
	@ApiOperation(value = "Update Student base on ID", notes = "Updated Student object will be returned base on the Student ID", response = Student.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Student not found") })
	public Student updateStudent(
			@ApiParam(value = "ID to be updated", required = true) @PathVariable int id,
			@ApiParam(value = "Student to be updated", required = true) @RequestBody Student student) {
		student.setId(id);
		return studentService.saveStudent(student);
	}

	@DeleteMapping("/students/{id}")
	@ApiOperation(value = "Delete Student base on ID", notes = "Delete Student object")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Student not found") })
	public void deleteStudent(
			@ApiParam(value = "Student ID to be delete", required = true) @PathVariable int id) {
		studentService.deleteStudentById(id);
	}
}
