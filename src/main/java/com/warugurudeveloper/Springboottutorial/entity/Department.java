package com.warugurudeveloper.Springboottutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Data
//default constructor
@NoArgsConstructor
//constructor with all arguments
@AllArgsConstructor
//Buider pattern
@Builder
@Entity
public class Department {
    //primary key
    @Id
    //how to generate theprimary key
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long departmentId;
    //validation
    @NotBlank(message = "Please Add Department Name ")
    private String departmentName;
    private String departmentAddress;
    private String departmentCodes;



}
