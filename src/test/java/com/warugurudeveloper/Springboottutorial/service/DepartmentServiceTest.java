package com.warugurudeveloper.Springboottutorial.service;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
//tells springboot this is a test class
@SpringBootTest
class DepartmentServiceTest {
    //autowire departmentService
    @Autowired
    private DepartmentService departmentService;
    //Mocking the repository
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        //configuration
        //this object will build
        //use this to create an object

        Department department =
                 Department.builder()
                .departmentName("IT")
                .departmentAddress("Kenya")
                .departmentCodes("IT06")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoresCase("IT"))
                .thenReturn(department);

    }
    //method
    @Test
    //disables the test case, when application running the test will be skipped
    @Disabled
    //displayName
    @DisplayName("Get Data based on valid department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName  = "IT";
        //what we are passing is saved in found, then try validating if what object being passed and object getting they are same
        Department found =
                departmentService.fetchDepartmentByName(departmentName);
        //if both are equal, then test case is valid if not equal the test is not valid
        assertEquals(departmentName,found.getDepartmentAddress());

    }
}