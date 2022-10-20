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
    private ICourseRepository courseRepository;

    //Create course
    @PostMapping(value ="/create")
    public Course create(@RequestBody Course course)
    {
        return courseRepository.save(course);
    }

    //Read course
    @GetMapping("/read")
    List<Course> getCourses(){return courseRepository.findAll();}

    //Update course
    @PutMapping("/update/{id}")
    Course updateCourse(@RequestBody Course newCourse,@PathVariable Long id)
    {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCourseName((newCourse.getCourseName()));
                    course.setCourseDescription((newCourse.getCourseDescription()));
                    course.setDepartmentId(newCourse.getDepartmentId());

                    return courseRepository.save(course);
                }).orElseThrow(()->new RuntimeException());
    }
    //Delete course
    @DeleteMapping("/delete/{id}")
   String deleteCourse(@PathVariable Long id)
    {
        if(!courseRepository.existsById(id))
    {
        throw new IllegalArgumentException("Course not found.");
    }
        courseRepository.deleteById(id);
        return "Course with id:  "  +id+  "  has been deleted successfully.";
    }

    //getAll
  //  public Set<Course> getAll() {return courseService.getAll();}
}
