package za.ac.cput.controller.impl;
/*
 * DepartmentController.java
 * Controller for the Department
 * Author: Mawande Langa (219074054)
 * Date: 09/10/2022
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Department;
import za.ac.cput.service.impl.DepartmentService;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //create Department
    @RequestMapping(value = "/department",method = RequestMethod.POST)
    public Department create(@RequestBody Department department){
        return departmentService.create(department);
    }

    //Read
    @GetMapping("/read/{id}")
    public Department read(@PathVariable String id){
        return departmentService.read(id);
    }

    //Update
    @PostMapping("/update")
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id){
        return departmentService.delete(id);
    }

    // Get all
    @GetMapping("/getAll")
    public Set<Department> getAll(){
        return departmentService.getAll();
    }
}
