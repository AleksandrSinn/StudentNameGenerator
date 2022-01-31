package com.andersen.studentnamegenerator.service.impl;

import com.andersen.studentnamegenerator.component.GeneratorComponent;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.entity.Students;
import com.andersen.studentnamegenerator.mapper.StudentsMapper;
import com.andersen.studentnamegenerator.repository.StudentsRepository;
import com.andersen.studentnamegenerator.service.StudentsGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsGeneratorServiceImpl implements StudentsGeneratorService {
    private final StudentsMapper studentsMapper;
    private final GeneratorComponent generatorComponent;
    private final StudentsRepository studentsRepository;

    @Override
    public StudentsResponseDto getRandomStudent() {
        return studentsMapper.toDto(generatorComponent.getRandomStudent());
    }

    @Override
    public List<StudentsResponseDto> getRandomPairOfAllStudents() {
        List<Students> pairOfTwoStudents = generatorComponent.getPairOfRandomStudent();
        return pairOfTwoStudents.stream().map(studentsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentsResponseDto> getRandomPairOfAllCaptains() {
        List<Students> pairOfTwoCaptains = generatorComponent.getPairOfRandomCaptain();
        return pairOfTwoCaptains.stream().map(studentsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentsResponseDto addRatingById(Long id, double point) {
        Students students = studentsRepository.findById(id).orElseThrow(NullPointerException::new);
        students.setRating(point);
        return studentsMapper.toDto(students);
    }
}
