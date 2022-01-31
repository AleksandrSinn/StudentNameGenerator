package com.andersen.studentnamegenerator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Students {
    @Id
    private Long id;
    @Column(name = "group_id")
    private int groupId;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private RoleInCompany role;
    private double rating;


    public enum RoleInCompany{
        STUDENT,
        CURATOR
    }
}