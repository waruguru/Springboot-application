package com.warugurudeveloper.Springboottutorial.controller;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.service.DepartmentService;
import com.warugurudeveloper.Springboottutorial.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    //autowire this service from your container,springboot,object autowired
    @Autowired
    private DepartmentService departmentService;
    //method to reate a department
    @PostMapping("/departments")
    //convert the JSON object converted to department object
    public Department saveDepartment(@RequestBody Department department){
//        DepartmentService service =new DepartmentServiceImpl() {
        return departmentService.saveDepartment(department);
        }
    }
}
