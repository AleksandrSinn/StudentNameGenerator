package com.andersen.studentnamegenerator.component;

import com.andersen.studentnamegenerator.entity.Students;
import com.andersen.studentnamegenerator.repository.StudentsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;


@RequiredArgsConstructor
@Getter
@Setter
@Component
public class GeneratorComponent {
    private final StudentsRepository studentsRepository;
    private static Students firstAskedStudent;
    private static Students lastAskedStudent;
    private static Students firstAskedCaptain;
    private static Students lastAskedCaptain;
    private static List<Students> randomStudents;
    private static List<Students> randomCaptains;
    private static List<Students> pairOfStudents;
    private static List<Students> pairOfCaptains;

    @PostConstruct
    public synchronized void beforeMethods(){
        randomStudents = studentsRepository.findAll();
        if(randomStudents.isEmpty()){
            finishOperations();
        }
        randomCaptains = studentsRepository.findAllByRole(Students.RoleInCompany.CAPTAIN);
        if(randomCaptains.isEmpty()){
            finishOperations();
        }
        Collections.shuffle(randomStudents);
        Collections.shuffle(randomCaptains);
        pairOfStudents = new ArrayList<>();
        pairOfCaptains = new ArrayList<>();
    }

    public synchronized Students getRandomStudent(){
        return randomStudents.remove(randomStudents.size() - 1);
    }

    public synchronized Students getRandomCaptain(){
        return randomCaptains.remove(randomCaptains.size() - 1);
    }

    public List<Students> getPairOfRandomStudent(){
        if(randomStudents.isEmpty()){
            finishOperations();
        }
        if(pairOfStudents.isEmpty()){
            firstAskedStudent = getRandomStudent();
            lastAskedStudent = getRandomStudent();
            pairOfStudents.add(firstAskedStudent);
            pairOfStudents.add(lastAskedStudent);
            return pairOfStudents;
        }
        if(pairOfStudents.size() == 1){
            pairOfStudents.add(firstAskedStudent);
            return pairOfStudents;
        }
        pairOfStudents.remove(0);
        lastAskedStudent = getRandomStudent();
        pairOfStudents.add(lastAskedStudent);
        return pairOfStudents;
    }

    public List<Students> getPairOfRandomCaptain(){
        if(randomCaptains.isEmpty()){
            finishOperations();
        }
        if(pairOfCaptains.isEmpty()){
            firstAskedCaptain = getRandomCaptain();
            lastAskedCaptain = getRandomCaptain();
            pairOfCaptains.add(firstAskedCaptain);
            pairOfCaptains.add(lastAskedCaptain);
            return pairOfCaptains;
        }
        if(pairOfCaptains.size() == 1){
            pairOfCaptains.add(firstAskedCaptain);
            return pairOfCaptains;
        }
        pairOfCaptains.remove(0);
        lastAskedCaptain = getRandomCaptain();
        pairOfCaptains.add(lastAskedCaptain);
        return pairOfCaptains;
    }

    public void restartMethod(){
        firstAskedStudent = null;
        lastAskedStudent = null;
        firstAskedCaptain = null;
        lastAskedCaptain = null;
        randomStudents = null;
        randomCaptains = null;
        pairOfStudents = null;
        pairOfCaptains = null;

        this.beforeMethods();
    }

    public void finishOperations(){
        System.out.println("Your array of students is Empty.");
    }
}
