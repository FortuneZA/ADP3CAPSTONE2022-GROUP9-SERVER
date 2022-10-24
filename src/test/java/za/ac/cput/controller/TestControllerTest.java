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
import za.ac.cput.entity.TestModel;
import za.ac.cput.factory.TestModelFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestModelControllerTest {

    private static TestModel test = new TestModelFactory().createTest("25AS","Advanced","25 October 2022","1Hour",25);
    private TestModel testTest;

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/test";


    @Test
    void a_create(){
        String url = BASE_URL + "/create";
        System.out.println("URL: "+url);
        ResponseEntity<TestModel> postResponse = restTemplate.postForEntity(url,test,TestModel.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        assertEquals(test.getTestId(),postResponse.getBody().getTestId());
        testTest = postResponse.getBody();
        System.out.println("Course created: "+testTest.toString());
    }

    @Test
    void b_read(){
        String url = BASE_URL +"/read/"+test.getTestId();
        System.out.println("URL: "+url);
        ResponseEntity<TestModel> response = restTemplate.getForEntity(url,TestModel.class);

        assertEquals(test.getTestId(),response.getBody().getTestId());


        testTest =  response.getBody();
        System.out.println("Reading: "+testTest.toString());
    }

    @Test
    void c_update() {

        String url = BASE_URL + "/update/";
        System.out.println("URL: " + url);
        TestModel updateTest = new TestModel
                .Builder()
                .copy(test)
                .setSubjectId("INM77")
                .setTestName("Information Systems Paper 2")
                .setTestDate("12 November 2022")
                .setDuration("2 Hours")
                .setResultInPercent(30)
                .build();
        ResponseEntity<TestModel> postResponse = restTemplate.postForEntity(url,updateTest,TestModel.class);

        assertNotNull(postResponse.getBody());

        testTest =  postResponse.getBody();
        System.out.println("Test Updated: "+testTest.toString());

    }

    @Test
    void d_getAll() {

        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println("Show all Tests: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
    @Test
    void e_delete()
    {
        String url = BASE_URL + "/delete" + test.getTestId();
        System.out.println("Test Deleted Successfuly!");
        restTemplate.delete(url);
    }


}
