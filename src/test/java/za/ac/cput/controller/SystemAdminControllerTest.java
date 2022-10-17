package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SystemAdminControllerTest {



    private static SystemAdmin systemAdmin =  SystemAdminFactory.createSystemAdmin("Khuzwayo", "khuzwayo@gmail.com");

    private SystemAdmin systemAdminTest;
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/systemAdmin";



    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<SystemAdmin> postResponse = restTemplate.postForEntity(url,systemAdmin,SystemAdmin.class);

        assertNotNull(postResponse);
        assertNotNull(systemAdmin);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(systemAdmin.getAdminName(),postResponse.getBody().getAdminName());

        systemAdminTest = postResponse.getBody();
        System.out.println("Saved data:" + systemAdminTest.toString());

}

    @Test
    void b_read() {

        String url = BASE_URL +"/read/"+ systemAdmin.getAdminEmail();
        System.out.println("URL:" +url);
        ResponseEntity<SystemAdmin> response = restTemplate.getForEntity(url ,  SystemAdmin.class);
        assertNotNull(response);
        assertNotNull(systemAdmin);
        assertEquals(systemAdmin.getAdminEmail(),response.getBody().getAdminEmail());
        systemAdminTest = response.getBody();
        System.out.println("Read: " + systemAdminTest.toString());
    }
    @Test
    void c_update()
    {
    SystemAdmin updated = new SystemAdmin.Builder().copy(systemAdmin).setAdminName("Tyler").setAdminEmail("Tyler@gmail.com").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data:" + updated);

        ResponseEntity<SystemAdmin> response = restTemplate.postForEntity(url,updated,SystemAdmin.class);
        assertNotNull(response);
        assertNotNull(systemAdmin);
        assertNotNull(response.getBody());



        systemAdminTest = response.getBody();
        System.out.println("update:" + updated);

    }
    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete" + systemAdmin.getAdminID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Get all: ");
        System.out.println(response.getBody());
    }


}