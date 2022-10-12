package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SystemAdminControllerTest {

    private static SystemAdmin systemAdmin = SystemAdminFactory.createSystemAdmin("Khuzwayo", "khuzwayo@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/systemAdmin";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<SystemAdmin> postResponse = restTemplate.postForEntity(url,systemAdmin,SystemAdmin.class);




}
}