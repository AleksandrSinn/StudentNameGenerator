package com.andersen.studentnamegenerator.service;

import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StudentsAdministrationService {
    public StudentsResponseDto getStudentById(Long id);
    public List<StudentsResponseDto> getAllStudents();
    public StudentsResponseDto deleteStudent(Long id);
    public StudentsResponseDto createStudent(StudentsRequestDto studentsRequestDto);
    public StudentsResponseDto updateStudent(Long id, StudentsRequestDto studentsRequestDto);
}
