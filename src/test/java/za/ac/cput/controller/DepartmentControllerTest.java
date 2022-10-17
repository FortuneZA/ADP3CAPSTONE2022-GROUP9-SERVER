package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DepartmentControllerTest {

    private static List<String> courseList = Arrays.asList("ICT in Application Development","Visual Communication Design","ICT in Communication Networks");
    private static Department department = DepartmentFactory.createDepartment("Information Technology","infor@cput.ac.za","+21-934259826",courseList);
    private Department testDepartment;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/department";

    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(url,department, Department.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(department.getDepartmentID(),postResponse.getBody().getDepartmentID());
        testDepartment = postResponse.getBody();
        System.out.println("Department created: "+ testDepartment.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL + "/read/" + department.getDepartmentID();
        System.out.println("URL: " + url);
        ResponseEntity<Department> response = restTemplate.getForEntity(url,Department.class);

        assertEquals(department.getDepartmentID(), response.getBody().getDepartmentID());

        testDepartment = response.getBody();
        System.out.println("Read: "+ testDepartment.toString());
    }

    @Test
    void c_update(){
        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);

        Department updateDepartment = new Department.Builder().copy(department).setDepartmentID("219074054").setDepartmentName("Finance").setDepartmentEmail("infor@cput.ac.za").setDepartmentTelephone("+21-74245526").setCourseList(courseList).build();
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(url,updateDepartment,Department.class);

        assertNotNull(postResponse.getBody());

        testDepartment = postResponse.getBody();
        System.out.println("Updated: "+ testDepartment.toString());
    }

    @Test
    void e_delete(){
        String url = BASE_URL + "/delete/" + department.getDepartmentID();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll(){
        String url = BASE_URL + "/getAll";
        System.out.println("URL: "+ url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println("Show all departments");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}