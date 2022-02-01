package com.andersen.studentnamegenerator.dto;
import com.andersen.studentnamegenerator.entity.Students;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentsResponseDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Students.RoleInCompany role;
}
