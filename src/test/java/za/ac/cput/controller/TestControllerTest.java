package za.ac.cput.controller;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
/*
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Test;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.factory.TestFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestControllerTest {

    private static Test test = new TestFactory().createTest("APPDEV01","ICT APPLICATION DEVELOPMENT","Fundamentals of Software Development","ICT01");
    private Test testCourse;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/course";


    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<Test> postResponse = restTemplate.postForEntity(url,test,Test.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(test.getTestId(),postResponse.getBody().getTestId());
        testCourse = postResponse.getBody();
        System.out.println("Course created: "+testCourse.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL +"/read/"+test.getTestId();
        System.out.println("URL: "+url);
        ResponseEntity<Test> response = restTemplate.getForEntity(url,Test.class);

        assertEquals(test.getTestId(),response.getBody().getTestId());


        testCourse = response.getBody();
        System.out.println("Reading: "+testCourse.toString());
    }

    @Test
    void c_update() {

        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Test updateTest = new Test.Builder().copy(test).setTestId("ARCH01").setCourseName("Architecture Development").setCourseDescription("Fundamentals of architecture studies").setDepartmentId("SJC2").build();
        ResponseEntity<Test> postResponse = restTemplate.postForEntity(url,updateTest,Test.class);

        assertNotNull(postResponse.getBody());

        testCourse = postResponse.getBody();
        System.out.println("Test Updated: "+testCourse.toString());

    }

    @Test
    void d_delete() {

        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show all Test: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}
*/