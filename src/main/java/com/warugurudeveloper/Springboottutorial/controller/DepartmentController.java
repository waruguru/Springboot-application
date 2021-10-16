package com.warugurudeveloper.Springboottutorial.controller;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.error.DepartmentNotFoundException;
import com.warugurudeveloper.Springboottutorial.service.DepartmentService;
import com.warugurudeveloper.Springboottutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    //adding the loggers
    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);
    //autowire this service from your container,springboot,object autowired
    @Autowired
    private DepartmentService departmentService;
    //method to reate a department
    @PostMapping("/departments")
    //convert the JSON object converted to department object
//    @Valid validates the request against
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside saveDepartment of DepartmentController");
//        DepartmentService service =new DepartmentServiceImpl() {
        return departmentService.saveDepartment(department);
        }
        //method to get all departments
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();

    }
    //metjhod to get a specific depatment
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("inside fetchDepartment of DepartmentController");
        return departmentService.fetchDepartmentByID(departmentId);

    }
    //method to delete department by id string
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }
    //method to update the department
    //Return type is department
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        //call service layer
        return departmentService.updateDepartment(departmentId,department);
    }
    //method to get department by name
    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);

    }

    }

