package za.ac.cput.service;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
/*
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.entity.Test;
import za.ac.cput.factory.TestFactory;
import za.ac.cput.service.impl.TestService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class TestServiceTest {

    private static TestService testService = TestService.getService();
    private static Test createdTest = (Test) TestFactory.createTest("RB115","1 November 2022","ADT262S");

    @Test
    void a_create(){

        Test create = testService.create(createdTest);
        assertEquals(create.getTestId(),createdTest.getTestId());
        System.out.println("ID#1: "+create.getTestId()+"\nID#2"+createdTest.getTestId()+"\n");

    }

    @Test
    void b_read(){
        Test read = TestService.read(createdTest.getStudentId());
        assertNotNull(read);
        System.out.println("Reading TestID: "+read+"\n");

    }

    @Test
    void c_update(){

        Test updated = new Test.Builder().copy(createdTest).setLectureID("NK458").build();
        assertNotNull(testService.update(updated));

        System.out.println("Current course ID: "+updated.getTestId()+"\nOld course ID: "+createdTest.getLectureId());

    }

    @Test
    void d_delete(){
        boolean deleted = testService.delete(createdTest.getTestId());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(testService.getAll()+"\n");
    }
*/

