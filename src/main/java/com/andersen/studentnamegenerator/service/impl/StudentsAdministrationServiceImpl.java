package com.andersen.studentnamegenerator.service.impl;

import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.entity.Students;
import com.andersen.studentnamegenerator.mapper.StudentsMapper;
import com.andersen.studentnamegenerator.repository.StudentsRepository;
import com.andersen.studentnamegenerator.service.StudentsAdministrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsAdministrationServiceImpl implements StudentsAdministrationService {
    private final StudentsMapper studentsMapper;
    private final StudentsRepository studentsRepository;

    @Override
    public StudentsResponseDto getStudentById(Long id) {
        return studentsMapper.toDto(studentsRepository.getById(id));
    }

    @Override
    public List<StudentsResponseDto> getAllStudents() {
        List<Students> studentsList = studentsRepository.findAll();
        return studentsList.stream().map(studentsMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentsResponseDto deleteStudent(Long id) {
        Students student = studentsRepository.getById(id);
        studentsRepository.delete(student);
        return studentsMapper.toDto(student);
    }

    @Override
    public StudentsResponseDto createStudent(StudentsRequestDto studentsRequestDto) {
        Students student = studentsMapper.toEntity(studentsRequestDto);
        return studentsMapper.toDto(studentsRepository.save(student));
    }

    @Override
    public StudentsResponseDto updateStudent(Long id, StudentsRequestDto studentsRequestDto) {
        Students student = studentsRepository.getById(id);
        studentsMapper.update(studentsMapper.toEntity(studentsRequestDto), student);
        return studentsMapper.toDto(studentsRepository.save(student));
    }
}
