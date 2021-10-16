package com.warugurudeveloper.Springboottutorial.service;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    //reference the repository
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }
}
