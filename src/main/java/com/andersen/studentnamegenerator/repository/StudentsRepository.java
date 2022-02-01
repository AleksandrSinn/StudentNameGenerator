package com.andersen.studentnamegenerator.repository;

import com.andersen.studentnamegenerator.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
    List<Students>findAllByRole(Students.RoleInCompany role);
}
