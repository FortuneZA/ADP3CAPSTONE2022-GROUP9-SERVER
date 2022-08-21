package za.ac.cput.Repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Course;

/*

 */
public interface ICourseRepository extends JpaRepository<Course,String> {
}
