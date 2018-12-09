package com.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapi.model.Employee;

//import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
