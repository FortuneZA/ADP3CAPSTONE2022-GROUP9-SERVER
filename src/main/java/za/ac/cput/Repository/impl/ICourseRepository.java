package za.ac.cput.Repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Course;

import java.util.Set;

/*
Generic Interface for CourseRepositroy class
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
@Repository
public interface ICourseRepository extends JpaRepository<Course,String> {

    Set<Course> getAll();
}
