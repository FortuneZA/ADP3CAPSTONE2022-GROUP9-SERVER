package za.ac.cput.controller.impl;


/*
 * Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date:13 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Student;
import za.ac.cput.service.impl.StudentService;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Create student
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Student create(@RequestBody Student student)
    {
        return studentService.create(student);
    }

    //Read student
    @GetMapping("/read/{id}")
    public Student read(@PathVariable String id)
    {
        return studentService.read(id);
    }

    //Update student
    @PostMapping("/update")
    public Student update(@RequestBody Student student)
    {
        return studentService.update(student);
    }

    //Delete student
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return studentService.delete(id);
    }

    //getAll
    @GetMapping("/getAll")
    public Set<Student> getAll()
    {return studentService.getAll();}
}
