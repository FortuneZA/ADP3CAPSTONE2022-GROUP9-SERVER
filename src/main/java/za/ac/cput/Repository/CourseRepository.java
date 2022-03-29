package za.ac.cput.Repository;

import za.ac.cput.Entity.Course;
import za.ac.cput.impl.ICourseRepository;

import java.util.HashSet;
import java.util.Set;

/* CourseRepository.java
  Repo for the Course Entity
 Author: Mathew Fortuin -219069514
 Date: 22/03/2022
*/
public class CourseRepository implements ICourseRepository {

    private static CourseRepository repository =null;
    private Set<Course> courseDB =null;

    private CourseRepository()
    {
        courseDB = new HashSet<Course>();
    }

    public static CourseRepository getRepository()
    {
        if(repository==null)
            repository = new CourseRepository();
        return repository;
    }

    @Override
    public Course create(Course course)
    {
        boolean success = this.courseDB.add(course);

        if(!success)
            return null;

        return course;
    }

    @Override
    public Course read(String courseID)
    {
        for(Course course:this.courseDB)
        {

            if(course.getCourseID().equalsIgnoreCase(courseID))
                return course;
        }

        return null;
    }

    @Override
    public Course update(Course course)
    {
        Course beforeUpdate=read(course.getCourseID());

        if(beforeUpdate!=null)
        {
            this.courseDB.remove(beforeUpdate);
            this.courseDB.add(course);
            return course;
        }
        return null;
    }

    @Override
   public boolean delete(String courseID)
    {
        Course courseToDelete =read(courseID);

        if(courseToDelete!=null)
        {
            this.courseDB.remove(courseToDelete);
            return true;
        }

        return false;
    }

    @Override
    public Set<Course>getAll()
    {
        return courseDB;
    }


}
