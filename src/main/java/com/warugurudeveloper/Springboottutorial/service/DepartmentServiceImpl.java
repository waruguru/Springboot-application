package com.warugurudeveloper.Springboottutorial.service;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import com.warugurudeveloper.Springboottutorial.error.DepartmentNotFoundException;
import com.warugurudeveloper.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    //reference the repository
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);

    }
//method to find all  departments in the database
    @Override
    public List<Department> fetchDepartmentList() {
       return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
//        return departmentRepository.findById(departmentId).get();
        Optional<Department>department =
                departmentRepository.findById(departmentId);
        //check if the department is present or not
        //if not throw exception department not found
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }
//nullchecks and empty checks for the 3 values
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        //getting department from db
       Department department1 =departmentRepository.findById(departmentId).get();
       //check if any of parameters are null, skip it if any value update
        if (Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())){
            department1.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCodes())&&!"".equalsIgnoreCase(department.getDepartmentCodes())){
            department1.setDepartmentCodes(department.getDepartmentCodes());
        }
        if (Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(department1);

    }
//findByDepartment is the name of attribute in the entity
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoresCase(departmentName);
    }

}
