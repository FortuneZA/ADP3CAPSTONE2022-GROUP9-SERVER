package za.ac.cput.controller;

/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    private static Student student = new StudentFactory().createStudent("Melissa","Yezmin","Willimas","mellisa@cput.ac.za","APDEV261");
    private Student testStudent;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/course";


    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url,student,Student.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(student.getStudentId(),postResponse.getBody().getStudentId());
        testStudent = postResponse.getBody();
        System.out.println("Course created: "+testStudent.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL +"/read/"+student.getStudentId();
        System.out.println("URL: "+url);
        ResponseEntity<Student> response = restTemplate.getForEntity(url,Student.class);

        assertEquals(student.getStudentId(),response.getBody().getStudentId());


        testStudent = response.getBody();
        System.out.println("Reading: "+testStudent.toString());
    }

    @Test
    void c_update() {

        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Student updateStudent = new Student.Builder().copy(student).setStudentId("21718596").setFirstName("Lindiwe").setMiddleName("chris").setLastName("Mhlongo").setStudentEmail("lindiwe@mycput.ac.za").setCourseID("741TY").build();
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url,updateStudent,Student.class);

        assertNotNull(postResponse.getBody());

        testStudent = postResponse.getBody();
        System.out.println("Student Updated: "+testStudent.toString());

    }

    @Test
    void d_delete() {

        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show all Students: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}
