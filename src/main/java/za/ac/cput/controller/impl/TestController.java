package za.ac.cput.controller.impl;

/*
 * Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date:13 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Test;
import za.ac.cput.service.impl.TestService;

import java.util.Set;

@RestController
@RequestMapping("/course")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Test create(@RequestBody Test test )
    {
        return testService.create(test);
    }


    @GetMapping("/read/{id}")
    public Test read(@PathVariable String id)
    {
        return testService.read(id);
    }

    @PostMapping("/update")
    public Test update(@RequestBody Test test )
    {
        return testService.update(test);
    }


    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return testService.delete(id);
    }

    //getAll
    public Set<Object> getAll() {return testService.getAll();}
}
