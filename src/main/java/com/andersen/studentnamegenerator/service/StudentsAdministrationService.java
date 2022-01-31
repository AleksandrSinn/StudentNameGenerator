package com.andersen.studentnamegenerator.service;

import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import java.util.List;

public interface StudentsAdministrationService {
    StudentsResponseDto getStudentById(Long id);
    List<StudentsResponseDto> getAllStudents();
    StudentsResponseDto deleteStudent(Long id);
    StudentsResponseDto createStudent(StudentsRequestDto studentsRequestDto);
    StudentsResponseDto updateStudent(Long id, StudentsRequestDto studentsRequestDto);
}
