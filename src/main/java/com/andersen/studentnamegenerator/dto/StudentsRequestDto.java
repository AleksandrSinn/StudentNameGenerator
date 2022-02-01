package com.andersen.studentnamegenerator.dto;

import com.andersen.studentnamegenerator.entity.Students;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentsRequestDto {
    private int groupId;
    private String firstname;
    private String lastname;
    private Students.RoleInCompany role;
    private Double rating;
}
