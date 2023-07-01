package com.example.demo.service;

import com.example.demo.dto.CreateFaculty;
import com.example.demo.dto.FacultyDto;
import com.example.demo.entity.Faculty;
import com.example.demo.exceotion.FacultyNotFoundException;
import com.example.demo.mapper.FacultyMapping;
import com.example.demo.repository.FacultyRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
     private final FacultyMapping facultyMapping;

    public FacultyService(FacultyRepository facultyRepository, FacultyMapping facultyMapping) {
        this.facultyRepository = facultyRepository;
        this.facultyMapping = facultyMapping;
    }


    public FacultyDto create(CreateFaculty createFaculty){
        return facultyMapping.toDto(facultyRepository.save(facultyMapping.toEntity(createFaculty)));
    }
    public FacultyDto update(long id, CreateFaculty createFaculty ){
        return facultyRepository.findById(id)
                .map(oldFaculty -> {
                    oldFaculty.setColor(createFaculty.getColor());
                    oldFaculty.setName(createFaculty.getName());
                    return facultyMapping.toDto(facultyRepository.save(oldFaculty));
                })
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public FacultyDto delete(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.delete(faculty);
        return facultyMapping.toDto(faculty);
    }
    public FacultyDto get(long id) {
        return facultyRepository.findById(id)
                .map(facultyMapping::toDto)
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }
    public List<FacultyDto> findAll(@Nullable String color) {
        return Optional.ofNullable(color)
                .map(facultyRepository::findAllByColor)
                .orElseGet(facultyRepository::findAll).stream()
                .map(facultyMapping::toDto)
                .collect(Collectors.toList());
    }


}
