package com.example.demo.mapper;

import com.example.demo.dto.CreateStudent;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student){
       StudentDto studentDto=new StudentDto();
       studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }
    public Student toEntity(CreateStudent createStudent){
        Student student =new Student();
        student.setAge(createStudent.getAge());
        student.setName(createStudent.getName());
        return student;
    }
}
