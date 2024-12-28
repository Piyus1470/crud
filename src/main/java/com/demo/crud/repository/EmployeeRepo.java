package com.demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.crud.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{

}
