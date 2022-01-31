package com.andersen.studentnamegenerator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentsRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
}
