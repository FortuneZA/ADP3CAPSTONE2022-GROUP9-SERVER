package za.ac.cput.Repository;



/*CourseRepositoryTest.java
Repository Test cases for Course
Author: Mathew Fortuin - 219069514
Date: 8/4/2022*/




import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Course;
import za.ac.cput.Factory.CourseFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CourseRepositoryTest {

    private CourseRepository courseRepo = CourseRepository.getRepository();

    private Course course = CourseFactory.createCourse("AD12","Architecture Design","Fundamentals of Building development","INFD");
    private Course course2 = CourseFactory.createCourse("JWD","Jewelry Design","Fundamentals of Jewelry making","INFD");
    private Course course3 = CourseFactory.createCourse("BS1","Business Science","Principles of Business Inteligence","BM");


    private Course courseCreated;


    @BeforeEach
    void test()
    {
        System.out.println("--TEST HEADER--");
    }

    void createCourse(Course course)
    {
        courseCreated = courseRepo.create(course);
    }

    @Order(1)
    @Test
    void a_create()
    {
        createCourse(course3);
        assertEquals(courseCreated.getCourseId(),course3.getCourseId());
        System.out.println("Course Created: "+courseCreated);
    }

    @Order(2)
    @Test
    void b_read()
    {
        createCourse(course2);
            Course courseRead = courseRepo.read(courseCreated.getCourseId());
        System.out.println("Course Details: "+courseRead);
    }

   /* @Order(3)
    @Test
    void c_update()
    {
        createCourse(course);
        Course courseUpdated = new Course.Builder().copy(course).courseName("Business Science").courseDescription("Fundamentals").build();
        courseUpdated =courseRepo.update(courseUpdated);
        System.out.println("OLD: {ID: "+course.getCourseId()+",Name: "+course.getCourseName()+",Description: "+course.getCourseDescription()+"\nNEW: {ID: "+courseUpdated.getCourseId()+"Name: "+courseUpdated.getCourseName()+",Description: "+courseUpdated.getCourseDescription());
    }*/

    @Order(4)
    @Test
    void d_delete()
    {
    createCourse(course);
    courseRepo.delete(course.getCourseId());
        System.out.println("Deleted: "+course.getCourseId());
        System.out.println(courseRepo.read(course.getCourseId()));
    }

    @Order(5)
    @Test
    void e_getAll()
    {
        System.out.println("Courses: "+courseRepo.getAll()+"\n");
    }

}
