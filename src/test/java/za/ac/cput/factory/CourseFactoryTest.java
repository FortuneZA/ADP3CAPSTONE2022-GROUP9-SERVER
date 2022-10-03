package za.ac.cput.factory;

/* CourseFactoryTest.java
   Test cases for Course
   Author: Mathew Fortuin - 219069514
   Date:  23 March 2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Course;

import static org.junit.jupiter.api.Assertions.*;

public class CourseFactoryTest {

   private final Course course = CourseFactory.createCourse("ICT800","Information and communication systems","The fundamentals of communication media within the IT industry","IT200");
   private final Course course2 = CourseFactory.createCourse("ARC405","Architectural Studies","The fundamentals of architectural principles  within the lanscape industry","IT200");

   private Course course1;


    //Successful Create
    @Test
    void successCreateCourse()
    {
      assertAll(
              ()->assertNotNull(course),
              ()->assertEquals("ICT800",course.getCourseId())
      );
    }

    //Fail Create
    @Test
    void failCreateCourse()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()->course1=CourseFactory.createCourse("ARC405","Architectural Studies", "The fundamentals of architectural principles  within the lanscape industry","IT200"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("course name was not provided."));
    }

    //TIMEOUT
    @Test
    @Timeout(1)
    public void Timeout()
    {
        successCreateCourse();
    }

    //DISABLE
    @Disabled
    @Test
    public void ObjectEquals()
    {
        failCreateCourse();
    }

    //Build Restrictions
   @Test
   public void TestNull()
   {
       Course course2 = CourseFactory.createCourse("ARC123","Architectural Studies","Fundamentals of Building design","INFD");
       assertNotEquals(course2,null);
   }
}
