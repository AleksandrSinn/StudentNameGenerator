package com.andersen.studentnamegenerator.service;

import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import java.util.List;

public interface StudentsGeneratorService {
    StudentsResponseDto getRandomStudent();
    List<StudentsResponseDto> getRandomPairOfAllStudents();
    List<StudentsResponseDto> getRandomPairOfAllCaptains();
    StudentsResponseDto addRatingById(Long id, double point);
}
