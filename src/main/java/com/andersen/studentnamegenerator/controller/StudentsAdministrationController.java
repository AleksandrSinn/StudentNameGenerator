package com.andersen.studentnamegenerator.controller;

import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.service.StudentsAdministrationService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/student")
@Api(description = "System management")
public class StudentsAdministrationController {
    private final StudentsAdministrationService studentsAdministrationService;

    @GetMapping("/{id}")
    public StudentsResponseDto getStudentById(@PathVariable Long id){
        return studentsAdministrationService.getStudentById(id);
    }
    @GetMapping("/all")
    public List<StudentsResponseDto> getAllStudents(){
        return studentsAdministrationService.getAllStudents();
    }
    @DeleteMapping("/{id}")
    public StudentsResponseDto deleteStudent(@PathVariable Long id){
        return studentsAdministrationService.deleteStudent(id);
    }
    @PostMapping("/create")
    public StudentsResponseDto createStudent(@RequestBody StudentsRequestDto studentsRequestDto){
        return studentsAdministrationService.createStudent(studentsRequestDto);
    }
    @PutMapping("/update/{id}")
    public StudentsResponseDto updateStudent(@PathVariable Long id,
                                            @RequestBody StudentsRequestDto studentsRequestDto){
        return studentsAdministrationService.updateStudent(id, studentsRequestDto);
    }




}
