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

   private Course course3 = course2;


    //Successful Create
    @Test
    void successCreateCourse()
    {
      assertAll(
              ()->assertNotNull(course),
              ()->assertEquals("ICT:800",course.getCourseId())
      );
    }

    //Test equality
    @Test
    void testEquality()
    {
        assertEquals(course2,course3);
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
        testEquality();
    }

    //Build Restrictions
   @Test
   public void TestNull()
   {
       Course course2 = CourseFactory.createCourse("ARC123","Architectural Studies","Fundamentals of Building design","INFD");
       assertNotEquals(course2,null);
   }
}
