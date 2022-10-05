package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;

import javax.xml.ws.Response;

import static org.junit.jupiter.api.Assertions.*;
/*
 * SubjectControllerTest.java
 * Test for the Subject controller
 * Author: Mathew Fortuin (219069514)
 * Date: 5 October 2022
 */

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubjectControllerTest {

    private static Subject subject = new SubjectFactory().createSubject("ITS","INFORMATION SYSTEMS",36,"WR12");
    private Subject testSubject;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/subject";


    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(url,subject,Subject.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(subject.getSubjectID(),postResponse.getBody().getSubjectID());
        testSubject = postResponse.getBody();
        System.out.println("Subject created: "+testSubject.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL +"/read/"+subject.getSubjectID();
        System.out.println("URL: "+url);
        ResponseEntity<Subject> response = restTemplate.getForEntity(url,Subject.class);

        assertEquals(subject.getSubjectID(),response.getBody().getSubjectID());


        testSubject = response.getBody();
        System.out.println("Reading: "+testSubject.toString());
    }

    @Test
    void c_update() {

        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        Subject updateSubject = new Subject.Builder().copy(subject).setSubjectID("ITS01").setSubjectName("INFORMATION SYSTEMS").setSubjectCredit(36).setLecturerID("WR21").build();
        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(url,updateSubject,Subject.class);

        assertNotNull(postResponse.getBody());

        testSubject = postResponse.getBody();
        System.out.println("Subject Updated: "+testSubject.toString());

    }

    @Test
    void d_delete() {

        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show all Subjects: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }


}