package com.andersen.studentnamegenerator.dto;
import com.andersen.studentnamegenerator.entity.Students;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentsResponseDto {
    private int groupId;
    private String firstName;
    private String lastName;
    private Students.RoleInCompany role;
}
