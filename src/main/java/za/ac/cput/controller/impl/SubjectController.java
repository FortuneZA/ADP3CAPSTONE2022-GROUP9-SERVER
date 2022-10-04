package za.ac.cput.controller.impl;

/*
 * SubjectController.java
 * Controller for the Subject service
 * Author: Mathew Fortuin (219069514)
 * Date: 4 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Subject;
import za.ac.cput.service.impl.SubjectService;

import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    //Create subject
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public Subject create(@RequestBody Subject subject)
    {
        return subjectService.create(subject);
    }

    //Read subject
    @GetMapping("/read/{id}")
    public Subject read(@PathVariable String id)
    {
        return subjectService.read(id);
    }

    //Update subject
    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject)
    {
        return subjectService.update(subject);
    }

    //Delete subject
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return subjectService.delete(id);
    }

    //getAll
    public Set<Subject> getAll() {return subjectService.getAll();}
}

