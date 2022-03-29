package za.ac.cput.Factory;

/* CourseFactoryTest.java
   Test cases for Course
   Author: Mathew Fortuin - 219069514
   Date:  23 March 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Course;

import static org.junit.jupiter.api.Assertions.*;

public class CourseFactoryTest {

    Course course = CourseFactory.createCourse("ICT800","Information and communication systems","The fundamentals of communication media within the IT industry","INFD");


    //OBJECT EQUALITY
    @Test
    public void ObjectEquality()
    {
        Course course2 = CourseFactory.createCourse("ARC123","Architectural Studies","Fundamentals of Building design","INFD");

        assertNotEquals(course2,course);
    }

    //OBJECT IDENTITY
    @Test
    public void ObjectIdentity()
    {
        Course course2 = course;
        assertEquals(course2,course);
    }

    //TIMEOUT
    @Test
    @Timeout(1)
    public void Timeout()
    {
        ObjectIdentity();
    }

    //DISABLE
    @Disabled
    @Test
    public void ObjectEquals()
    {
        Course course2 = CourseFactory.createCourse("ARC123","Architectural Studies","Fundamentals of Building design","INFD");

        assertEquals(course2,course);
    }

    //BUILD RESTRICTIONS
   @Test
   public void TestNull()
   {
       Course course2 = CourseFactory.createCourse("ARC123","Architectural Studies","Fundamentals of Building design","INFD");
       assertNotEquals(course2,null);
   }
}
