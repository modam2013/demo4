package com.example.demo.controller;

import com.example.demo.dto.CreateFaculty;
import com.example.demo.dto.FacultyDto;
import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/faculties")
@Tag(name = "Контроллер по работе с факультетами")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyDto create(@RequestBody CreateFaculty facultyDtoIn) {
        return facultyService.create(facultyDtoIn);
    }

    @PutMapping("/{id}")
    public FacultyDto update(@PathVariable("id") long id, @RequestBody CreateFaculty createFaculty) {
        return facultyService.update(id, createFaculty);
    }

    @GetMapping("/{id}")
    public FacultyDto get(@PathVariable("id") long id) {
        return facultyService.get(id);
    }

    @DeleteMapping("/{id}")
    public FacultyDto delete(@PathVariable("id") long id) {
        return facultyService.delete(id);
    }

    @GetMapping
    public List<FacultyDto> findAll(@RequestParam(required = false) String color) {
        return facultyService.findAll(color);
    }


}
