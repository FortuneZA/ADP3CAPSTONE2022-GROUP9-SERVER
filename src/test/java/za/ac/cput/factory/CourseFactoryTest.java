package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseFactoryTest {


    private final Course course = CourseFactory.createCourse("Networking Systems","Fundamentals of Network security","NET03");
    private final  Course course2 = CourseFactory.createCourse("Information Systems","Fundamentals of daatabase manipulation","IS3");

    private Course course3 = course2;

    //Successful Create
    @Test
    void successfulCreateCourse()
    {
        assertAll(
                ()->assertNotNull(course),
                ()->assertEquals("ITS03",course.getDepartmentId())

        );
    }

    //Test Equality
    @Test
    void testEquality()
    {
        assertEquals(course3,course2);
    }

    //TIMEOUT
    @Test
    public void Timeout()
    {
        successfulCreateCourse();
    }

    //DISABLED
    @Test
    @Disabled
    public void Disabled()
    {
        testEquality();
    }

    //Build Verification
    @Test
    public void TestNull()
    {
        Course course2 = CourseFactory.createCourse("Information Systems","Fundamentals of daatabase manipulation","IS3");
        assertNotEquals(course2,null);
    }


}