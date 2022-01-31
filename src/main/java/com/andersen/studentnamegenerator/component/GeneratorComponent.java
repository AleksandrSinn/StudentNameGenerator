package com.andersen.studentnamegenerator.component;

import com.andersen.studentnamegenerator.entity.Students;
import com.andersen.studentnamegenerator.repository.StudentsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Getter
@Setter
@Component
public class GeneratorComponent {
    private final StudentsRepository studentsRepository;
    private static Students lastAskedStudent;
    private static Students lastAskedCaptain;
    private static List<Students> randomStudents;
    private static List<Students> pairOfStudents;
    private static List<Students> randomCaptains;
    private static List<Students> pairOfCaptains;
    private static List<Students> studentsList;

    public synchronized void beforeMethods(){
        studentsList = studentsRepository.findAll();
        randomStudents = new ArrayList<>(studentsList);
        Collections.shuffle(randomStudents);
        pairOfStudents = new ArrayList<>();
    }

    public synchronized Students getRandomStudent(){
        beforeMethods();
        return randomStudents.remove(randomStudents.size() - 1);
    }

    public List<Students> getPairOfRandomStudent(){
        beforeMethods();
        if(pairOfStudents.isEmpty()){
            pairOfStudents.add(getRandomStudent());
            lastAskedStudent = getRandomStudent();
            pairOfStudents.add(lastAskedStudent);
            return pairOfStudents;
        }
        pairOfStudents.remove(0);
        lastAskedStudent = getRandomStudent();
        pairOfStudents.add(lastAskedStudent);
        return pairOfStudents;
    }

    public List<Students> getPairOfRandomCaptain(){
        randomCaptains = studentsList.stream()
                .filter(student -> student.getRole() == Students.RoleInCompany.CAPTAIN)
                .collect(Collectors.toList());
        if(pairOfCaptains.isEmpty()){
            pairOfCaptains.add(randomCaptains.remove(randomCaptains.size() - 1));
            lastAskedCaptain = randomCaptains.remove(randomCaptains.size() - 1);
            pairOfCaptains.add(lastAskedCaptain);
            return pairOfCaptains;
        }
        pairOfCaptains.remove(0);
        lastAskedCaptain = pairOfCaptains.remove(pairOfCaptains.size() - 1);
        pairOfCaptains.add(lastAskedCaptain);
        return pairOfCaptains;
    }



}
