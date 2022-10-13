package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FacultyControllerTest {


    private static List<String> departmentList = Arrays.asList("Information Technology","Applied Design","Media");
    private static Faculty faculty = FacultyFactory.createFaculty("Informatics & Design",departmentList);
    private Faculty testFaculty;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/faculty";

    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+ url);
        ResponseEntity<Faculty> postResponse = restTemplate.postForEntity(url, faculty, Faculty.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(faculty.getFacultyID(), postResponse.getBody().getFacultyID());

        testFaculty = postResponse.getBody();
        System.out.println("Created faculty: "+ testFaculty.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL + "/read/" + faculty.getFacultyID();
        System.out.println("URL: " + url);
        ResponseEntity<Faculty> response = restTemplate.getForEntity(url, Faculty.class);

        assertEquals(faculty.getFacultyID(), response.getBody().getFacultyID());

        testFaculty = response.getBody();
        System.out.println("Read: " + testFaculty.toString());
    }

    @Test
    void c_update(){
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);

        Faculty updateFaculty = new Faculty.Builder().copy(faculty).setFacultyID("2190774054").setFacultyName("Engineering").setDepartmentList(departmentList).build();
        ResponseEntity<Faculty> postResponse = restTemplate.postForEntity(url, updateFaculty, Faculty.class);

        assertNotNull(postResponse.getBody());

        testFaculty = postResponse.getBody();
        System.out.println("Update faculty: "+ testFaculty.toString());
    }

    @Test
    void d_delete(){
        String url = BASE_URL + "/delete/" + faculty.getFacultyID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll(){
        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all Faculties");
        System.out.println(response);
        System.out.println(response.getBody());
    }


}