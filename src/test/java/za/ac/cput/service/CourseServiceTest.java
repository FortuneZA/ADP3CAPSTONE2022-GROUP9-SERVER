package za.ac.cput.service;
/*
CourseServiceTest.java
Test cases for CourseService
Author: Mathew Fortuin (219069514)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Course;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.service.impl.CourseService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class CourseServiceTest {
    private final Course course= CourseFactory.createCourse("Accounting","Fundamentals of finance","FIN24");

    private Course courseCreated;

    @Autowired
    private CourseService courseService;

    void createCourse(Course cor) {
        courseCreated=courseService.create(cor);
    }

    @Test
    void d_getAll()
    {
        Set<Course> courseSet=courseService.getAll();
        System.out.println(courseSet);
    }

    @Test
    void a_create()
    {
        createCourse(course);
        assertEquals("ICT:Applications Development",courseCreated.getCourseName());
        System.out.println("Created: "+courseCreated);
    }

    @Test
    void b_read()
    {
        createCourse(course);
        Course courseRead= courseService.read(courseCreated.getCourseId());
        System.out.println("Read: "+courseRead);
    }

    @Test
    void c_update()
    {
        createCourse(course);
        Course courseUpdate=new Course
                .Builder()
                .copy(course)
                .setDepartmentId("ICT7800")
                .build();
        courseService.update(courseUpdate);
        System.out.println("Updated: "+courseUpdate);
    }

    @Test
    void e_delete()
    {
        createCourse(course);
        boolean delete=courseService.delete(course.getCourseId());
        assertTrue(delete);
    }



}