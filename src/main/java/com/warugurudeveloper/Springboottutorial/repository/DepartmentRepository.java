package com.warugurudeveloper.Springboottutorial.repository;

import com.warugurudeveloper.Springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Pass Entity and the primary key datatype
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
