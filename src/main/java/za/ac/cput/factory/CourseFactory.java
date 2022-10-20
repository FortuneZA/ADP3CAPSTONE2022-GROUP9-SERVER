package za.ac.cput.factory;


/* CourseFactory.java
 Factory Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 8/08/2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.entity.Course;

import java.util.LinkedList;

public class CourseFactory
{
    public static Course createCourse(String courseName,String courseDescription,String departmentId)
    {



         if(!StringUtils.hasLength(courseName))
             throw new IllegalArgumentException("course name was not provided.");
         if(!StringUtils.hasLength(courseDescription))
             throw new IllegalArgumentException("course description was not provided.");
         if(!StringUtils.hasLength(departmentId))
             throw new IllegalArgumentException("faculty ID was not provided.");


        return new Course.Builder()

                .setCourseName("ICT:Applications Development")
                .setCourseDescription("Information and communication systems")
                .setDepartmentId("ITS03")
                .setSubjectList(new LinkedList())
                .build();


    }
}
