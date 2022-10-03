package za.ac.cput.service;

/*
CourseService.java
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Course;
import za.ac.cput.repository.impl.ICourseRepository;
import za.ac.cput.service.impl.ICourseService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {


    @Autowired
    private ICourseRepository   courseRepository;

    @Override
    public Course create(Course course){return this.courseRepository.save(course);}

    @Override
    public Course read(String courseId){return this.courseRepository.findById(courseId).orElseGet(null);}

    @Override
    public Course update(Course course)
    {
        if(this.courseRepository.existsById(course.getCourseId()))
        {
            return this.courseRepository.save(course);
        }

        return null;
    }

    @Override
    public boolean delete(String id)
    {
        this.courseRepository.deleteById(id);

        if(this.courseRepository.existsById(id)) return false;
        else return true;
    }

  @Override
  public Set<Course> getAll() {return this.courseRepository.findAll().stream().collect(Collectors.toSet()); }

}
