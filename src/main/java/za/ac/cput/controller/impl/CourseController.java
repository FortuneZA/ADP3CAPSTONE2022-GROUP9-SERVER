package za.ac.cput.controller.impl;

/*
 * CourseController.java
 * Controller for the Course service
 * Author: Mathew Fortuin (219069514)
 * Date: 4 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Course;
import za.ac.cput.repository.impl.ICourseRepository;
import za.ac.cput.service.impl.CourseService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //Create course
    @PostMapping(value ="/create")
    public Course create(@RequestBody Course course)
    {
        return courseService.create(course);
    }

    //Read course
    @GetMapping("/read/{id}")
    public Course read(@PathVariable Integer id){return courseService.read(id);}

    //Update course
    @PostMapping("/update")
   public Course update(@RequestBody Course course){

        return courseService.update(course);
    }

    //Delete course
    @DeleteMapping("/delete/{id}")
   public boolean delete(@PathVariable Integer id){return courseService.delete(id);}

    //getAll
    public Set<Course> getAll() {return courseService.getAll();}
}
