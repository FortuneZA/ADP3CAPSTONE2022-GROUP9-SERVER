package za.ac.cput.service.impl;

import za.ac.cput.Entity.Course;
import za.ac.cput.service.IService;

import java.util.Set;

/*
Interface for CourseService class
Author: Mathew Fortuin
Date: 21/8/2022
 */
public interface ICourseService extends IService<Course,String> {

    Set<Course> getAll();
}
