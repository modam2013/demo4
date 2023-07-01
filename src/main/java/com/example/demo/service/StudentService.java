package com.example.demo.service;

import com.example.demo.dto.CreateFaculty;
import com.example.demo.dto.CreateStudent;
import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import com.example.demo.exceotion.FacultyNotFoundException;
import com.example.demo.exceotion.StudentNotFoundException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    public StudentDto create(CreateStudent createStudent){
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(createStudent)));
    }
    public StudentDto update(long id, CreateStudent createStudent ){
        return studentRepository.findById(id)
                .map(oldFaculty -> {
                    oldFaculty.setAge(createStudent.getAge());
                    oldFaculty.setName(createStudent.getName());
                    return studentMapper.toDto(studentRepository.save(oldFaculty));
                })
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public StudentDto delete(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }

    public StudentDto get(long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }
    public List<StudentDto> findAll(@Nullable Integer age) {
        return Optional.ofNullable(age)
                .map(studentRepository::findAllByAge)
                .orElseGet(studentRepository::findAll).stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }
}
