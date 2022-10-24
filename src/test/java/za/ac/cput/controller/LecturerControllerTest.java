package za.ac.cput.controller;
/*
LecturerControllerTest.java
Test class for the Lecturer Controller
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
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LecturerControllerTest {

    private Lecturer lecturer= LecturerFactory.createLecturer("Cameron","Henry","Noemdo","chn@cput.ac.za","ICT-ADP-321");

    @Autowired
    private TestRestTemplate restTemplate;

    private final HttpHeaders httpHeaders=new HttpHeaders();

    private final String lecturerURL="http://localhost:8080/lecturer";

    private final String username="";

    private final String password="";

    @Test
    void a_create() {
        String url=lecturerURL+"/create";
        ResponseEntity<Lecturer> responseEntity=restTemplate.postForEntity(url,lecturer,Lecturer.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        lecturer=responseEntity.getBody();
        System.out.println("Created: "+lecturer);
        assertEquals(lecturer.getLecturerId(),responseEntity.getBody().getLecturerId());
    }

    @Test
    void b_read() {
        a_create();
        String url=lecturerURL+"/read/"+lecturer.getLecturerId();
        ResponseEntity<Lecturer> responseEntity=restTemplate.getForEntity(url,Lecturer.class);
        lecturer=responseEntity.getBody();
        assert lecturer != null;
        assertEquals(lecturer.getLecturerId(), Objects.requireNonNull(responseEntity.getBody()).getLecturerId());
        System.out.println("Read: "+lecturer.toString());
    }

    @Test
    void c_update() {
        a_create();
        String url=lecturerURL+"/update";
        Lecturer updateLecturer=new Lecturer.Builder().copy(lecturer).setLecturerEmail("cameronHnoemdo@cput.ac.za").setDepartmentId("ADP00000").build();
        ResponseEntity<Lecturer> responseEntity=restTemplate.postForEntity(url,updateLecturer,Lecturer.class);
        lecturer=responseEntity.getBody();
        System.out.println("Updated: "+lecturer);
        assertEquals("cameronHnoemdo@cput.ac.za",lecturer.getLecturerEmail());
    }

    @Test
    void e_delete() {
        String url=lecturerURL+"/delete/"+lecturer.getLecturerId();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url=lecturerURL+"/getall";
        HttpEntity<String> httpEntity=new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
        assertNotNull(responseEntity.getBody());
        System.out.println("All lecturers: "+ responseEntity.getBody());
    }

}