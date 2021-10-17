package com.warugurudeveloper.Springboottutorial.controller;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.error.DepartmentNotFoundException;
import com.warugurudeveloper.Springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//test endpoints
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    //Mock the MVC
    @Autowired
    private MockMvc mockMvc;

    //mock bean mock service layer
    @Autowired
    private DepartmentService departmentService;

    //create departmeent object
    private Department department;

    @BeforeEach
    void setUp() {
        //create the object to be used in test cases
        department = Department.builder()
                .departmentAddress("Uganda")
                .departmentCodes("08IT")
                .departmentName("AtlasCopco")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        //create the object to be used in test cases
      Department  inputdepartment = Department.builder()
                .departmentAddress("Uganda")
                .departmentCodes("08IT")
                .departmentName("AtlasCopco")
                .build();

      //mock it
        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        //call the endpoint
        mockMvc.perform(post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .contentType("JSON data"))
                .andExpect(status().isOk());


    }

    @Test
    void fetchDepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchDepartmentByID(1L))
                .thenReturn(department);
        //perform get operation
        mockMvc.perform(get("departments")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}