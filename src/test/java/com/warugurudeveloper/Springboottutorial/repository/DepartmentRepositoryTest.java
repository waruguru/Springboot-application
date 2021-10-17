package com.warugurudeveloper.Springboottutorial.repository;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {
    //object for repository
    @Autowired
    private DepartmentRepository departmentRepository;

    //Entity manager for Junit and Mockito
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        //create department object
        Department department =
                Department.builder()
                .departmentName("MechanicalDepartment")
                .departmentCodes("department12")
                .departmentAddress("Kenya")
                .build();
        //the above is the object we want to persist ,
        //the object will be persisted before calling the test below
        testEntityManager.persist(department);
     }
    //implement find by id
    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department =departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"MechanicalDepartment ");

    }
}