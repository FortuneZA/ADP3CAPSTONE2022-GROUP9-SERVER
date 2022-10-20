package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Course;
import za.ac.cput.factory.CourseFactory;

import javax.xml.ws.Response;

import static org.junit.jupiter.api.Assertions.*;
/*
 * CourseControllerTest.java
 * Test for the Course controller
 * Author: Mathew Fortuin (219069514)
 * Date: 5 October 2022
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseControllerTest {

    private static Course course = new CourseFactory().createCourse("APPDEV01","ICT APPLICATION DEVELOPMENT","Fundamentals of Software Development");
    private Course testCourse;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/course";


    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(url,course,Course.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(course.getCourseName(),postResponse.getBody().getCourseName());
        testCourse = postResponse.getBody();
        System.out.println("Course created: "+testCourse.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL +"/read/"+course.getCourseId();
        System.out.println("URL: "+url);
        ResponseEntity<Course> response = restTemplate.getForEntity(url,Course.class);

        assertEquals(course.getCourseId(),response.getBody().getCourseId());


        testCourse = response.getBody();
        System.out.println("Reading: "+testCourse.toString());
    }

    @Test
    void c_update() {

        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Course updateCourse = new Course.Builder().copy(course).setCourseName("Architecture Development").setCourseDescription("Fundamentals of architecture studies").setDepartmentId("SJC2").build();
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(url,updateCourse,Course.class);

        assertNotNull(postResponse.getBody());

        testCourse = postResponse.getBody();
        System.out.println("Course Updated: "+testCourse.toString());

    }

    @Test
    void d_delete() {

        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show all Courses: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}