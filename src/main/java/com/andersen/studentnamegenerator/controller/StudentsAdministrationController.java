package com.andersen.studentnamegenerator.controller;

import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.service.StudentsAdministrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/student")
@Api(value = "Operations with student")
public class StudentsAdministrationController {
    private final StudentsAdministrationService studentsAdministrationService;

    @ApiOperation(value = "find one of all students", response = StudentsResponseDto.class)
    @GetMapping("/{id}")
    public StudentsResponseDto getStudentById(@PathVariable Long id){
        return studentsAdministrationService.getStudentById(id);
    }

    @ApiOperation(value = "find all of students", response = StudentsResponseDto.class)
    @GetMapping("/all")
    public List<StudentsResponseDto> getAllStudents(){
        return studentsAdministrationService.getAllStudents();
    }

    @ApiOperation("delete a student")
    @DeleteMapping("/{id}")
    public StudentsResponseDto deleteStudent(@PathVariable Long id){
        return studentsAdministrationService.deleteStudent(id);
    }

    @ApiOperation(value = "Create one of student", response = StudentsResponseDto.class)
    @PostMapping("/create")
    public StudentsResponseDto createStudent(@RequestBody StudentsRequestDto studentsRequestDto){
        return studentsAdministrationService.createStudent(studentsRequestDto);
    }

    @ApiOperation(value = "update the student", response = StudentsResponseDto.class)
    @PutMapping("/update/{id}")
    public StudentsResponseDto updateStudent(@PathVariable Long id,
                                            @RequestBody StudentsRequestDto studentsRequestDto){
        return studentsAdministrationService.updateStudent(id, studentsRequestDto);
    }
}
