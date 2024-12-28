package com.demo.crud.service;

import java.util.List;

import com.demo.crud.entities.Employee;

public interface MyService 
{
    Employee save(Employee emp);

    Employee get(int id);

    List<Employee> getAll();

    Employee update(Employee emp);

    void delete(int id);
}
