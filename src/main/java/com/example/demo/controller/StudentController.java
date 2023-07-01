package com.example.demo.controller;

import com.example.demo.dto.CreateStudent;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto create(@RequestBody CreateStudent createStudent) {
        return studentService.create(createStudent);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable("id") long id, @RequestBody CreateStudent createStudent) {
        return studentService.update(id, createStudent);
    }

    @GetMapping("/{id}")
    public StudentDto get(@PathVariable("id") long id) {
        return studentService.get(id);
    }

    @DeleteMapping("/{id}")
    public StudentDto delete(@PathVariable("id") long id) {
        return studentService.delete(id);
    }

    @GetMapping
    public List<StudentDto> findAll(@RequestParam(required = false) Integer age) {
        return studentService.findAll(age);
    }


}