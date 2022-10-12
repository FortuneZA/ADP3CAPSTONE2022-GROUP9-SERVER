package za.ac.cput.controller;
/*
 * Name:Themba
 * Surname:Khanyile
 * StudentNumber:217238173
 * Date: 12 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Course;
import za.ac.cput.service.impl.CourseService;

import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestController 
{
  
    @Autowired
    private TestService testService;

    //Create Test
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Test create(@RequestBody Test test)
    {
        return testService.create(test);
    }

    //Read Test
    @GetMapping("/read/{id}")
    public Test read(@PathVariable String id)
    {
        return testService.read(id);
    }

    //Update Test
    @PostMapping("/update")
    public Test update(@RequestBody Test test)
    {
        return testService.update(test);
    }

    //Delete Test
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return testService.delete(id);
    }

    //getAll
    public Set<Test> getAll() {return testService.getAll();}
}
