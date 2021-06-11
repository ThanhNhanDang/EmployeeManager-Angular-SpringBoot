package com.java.repo;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.entity.Employee;

@Repository
@Scope("prtotype")
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
