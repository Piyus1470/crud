package com.demo.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.entities.Employee;
import com.demo.crud.service.MyService;

@RestController
public class MyController 
{
      @Autowired
      MyService myService;

       @PostMapping("/save")
       public Employee insert(@RequestBody Employee emp)
       {
           return myService.save(emp) ;  
       }

       @GetMapping("/get/{id}")
       public Employee fetch(@PathVariable String id)
       {
        return myService.get(Integer.parseInt(id));
       }

       @GetMapping("/getAll")
       public List<Employee> fetchAll()
       {
          return myService.getAll();
       }

       @PutMapping("/update")
       public Employee changes(@RequestBody Employee emp)
       {
             return myService.update(emp);
       }

       @DeleteMapping("/delete/{id}")
       public String erase(@PathVariable String id)
       {
             Employee emp = myService.get(Integer.parseInt(id));
             if(emp==null)
             {
                return "data does not exist";
             }
             else
             {
                myService.delete(Integer.parseInt(id));
                return "Data delete Succesfully";
             }
       }


}
