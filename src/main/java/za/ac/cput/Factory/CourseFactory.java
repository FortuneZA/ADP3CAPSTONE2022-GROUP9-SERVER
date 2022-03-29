package za.ac.cput.Factory;


/* CourseFactory.java
 Factory Class for the Course entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/

import za.ac.cput.Entity.Course;
import za.ac.cput.Util.GenericHelper;

public class CourseFactory
{
    public static Course createCourse(String courseID,String courseName,String courseDescription,String facultyID)
    {
        String courseHelper = GenericHelper.generateID();
        Course course = new Course.Builder()
                .courseID("ICT:APPDEV")
                .courseName("ICT:Applications Development")
                .courseDescription("Programming foundations and business practices regarding software development.")
                .facultyID("INFDSGN")
                .build();

        return course;
    }
}
