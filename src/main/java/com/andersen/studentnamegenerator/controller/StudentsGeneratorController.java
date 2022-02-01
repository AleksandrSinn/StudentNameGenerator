package com.andersen.studentnamegenerator.controller;

import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.service.StudentsGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/generator")
public class StudentsGeneratorController {
    private final StudentsGeneratorService studentsGeneratorService;

    @GetMapping("/random")
    public StudentsResponseDto getRandomStudent(){
        return studentsGeneratorService.getRandomStudent();
    }

    @GetMapping("/pair/students")
    public List<StudentsResponseDto> getPairOfStudents(){
        return studentsGeneratorService.getRandomPairOfAllStudents();
    }

    @GetMapping("/pair/captains")
    public List<StudentsResponseDto> getPairOfCaptains(){
        return studentsGeneratorService.getRandomPairOfAllCaptains();
    }

    @GetMapping("/addRating/{id}/{point}")
    public StudentsResponseDto addPointById(@PathVariable Long id,
            @PathVariable Double point){
        return studentsGeneratorService.addRatingById(id, point);
    }

    @GetMapping("/restart")
    public void restartStudentsGenerator(){
        studentsGeneratorService.restartStudentsGenerator();
    }
}
