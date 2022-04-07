package za.ac.cput.impl;

/* ICourseRepository.java
 Interface for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 18/03/2022
*/

import za.ac.cput.Entity.Course;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ICourseRepository extends IRepository<Course,String> {

    public Set<Course> getAll();

}
