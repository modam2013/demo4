package com.example.demo.mapper;

import com.example.demo.dto.CreateFaculty;
import com.example.demo.dto.CreateStudent;
import com.example.demo.dto.FacultyDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapping {
    public FacultyDto toDto(Faculty faculty){
        FacultyDto facultyDto=new FacultyDto();
       faculty.setId(faculty.getId());
       faculty.setName(faculty.getName());
        faculty.setColor(faculty.getColor());
        return facultyDto;
    }
    public Faculty toEntity(CreateFaculty createFaculty){
        Faculty faculty =new Faculty();
       faculty.setColor(createFaculty.getColor());
        faculty.setName(createFaculty.getName());
        return faculty;
    }
}
