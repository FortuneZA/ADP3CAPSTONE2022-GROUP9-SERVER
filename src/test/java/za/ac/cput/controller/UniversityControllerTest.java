package za.ac.cput.controller;
/*
UniversityControllerTest.java
Test class for the University Controller
Author: Cameron Henry Noemdo (219115443)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.University;
import za.ac.cput.factory.UniversityFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UniversityControllerTest {

    //String[] list={"Applied Sciences","Business","Education"};

    //List<String> facultyList= Arrays.asList(list);

    private University university= UniversityFactory.createUniversity("CPUT", "cput@cput.ac.za");

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders=new HttpHeaders();

    private final String universityURL="http://localhost:8080/university";

    private final String username="Admin";

    private final String password="Admin123";

    @Test
    void a_create() {
        String url=universityURL+"/create";
        httpHeaders.setBasicAuth(username,password);
        HttpEntity<University> httpEntity=new HttpEntity<>(university,httpHeaders);
        ResponseEntity<University> responseEntity=restTemplate.postForEntity(url,httpEntity,University.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        university=responseEntity.getBody();
        System.out.println("Created: "+university);
        assertEquals(university.getUniversityId(),responseEntity.getBody().getUniversityId());
    }

    @Test
    void b_read() {
        a_create();
        httpHeaders.setBasicAuth(username,password);
        HttpEntity<University> httpEntity=new HttpEntity<>(university,httpHeaders);
        String url=universityURL+"/read/"+university.getUniversityId();
        ResponseEntity<University> responseEntity=restTemplate.exchange(url,HttpMethod.GET,httpEntity,University.class);
        university=responseEntity.getBody();
        assert university != null;
        assertEquals(university.getUniversityId(), Objects.requireNonNull(responseEntity.getBody()).getUniversityId());
        System.out.println("Read: "+university.toString());
    }

    @Test
    void c_update() {
        a_create();
        String url=universityURL+"/update";
        University updateUniversity=new University.Builder().copy(university).setEmail("cput@edu.co.za").build();
        httpHeaders.setBasicAuth(username,password);
        HttpEntity<University> httpEntity=new HttpEntity<>(updateUniversity,httpHeaders);
        ResponseEntity<University> responseEntity=restTemplate.postForEntity(url,httpEntity,University.class);
        university=responseEntity.getBody();
        System.out.println("Updated: "+university);
        assertEquals("cput@edu.co.za",university.getEmail());
    }

    @Test
    void e_delete() {
        String url=universityURL+"/delete/"+university.getUniversityId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url=universityURL+"/getall";
        HttpEntity<String> httpEntity=new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
        assertNotNull(responseEntity.getBody());
        System.out.println("All universities: "+ responseEntity.getBody());
    }
}