package com.demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.entities.Employee;
import com.demo.crud.repository.EmployeeRepo;

@Service
public class MyServiceImpl implements MyService
{

    @Autowired
     EmployeeRepo employeeRepo;

    @Override
    public Employee save(Employee emp) 
    {
       return employeeRepo.save(emp);
    }

    @Override
    public Employee get(int id)
     {
        return employeeRepo.findById(id).orElse(null);
     }

    @Override
    public List<Employee> getAll() 
    {
        return employeeRepo.findAll();
    }

    @Override
    public Employee update(Employee emp)
     {
            Employee emp1 = get(emp.getId());
            if(emp1==null) return null;
            emp1.setName(emp.getName());
            emp1.setAddress(emp.getAddress());
            emp1.setGender(emp.getGender());
            emp1.setSalary(emp.getSalary());

            return employeeRepo.saveAndFlush(emp1);
     }

    @Override
    public void delete(int id)
     {
         employeeRepo.deleteById(id);
     }

}
