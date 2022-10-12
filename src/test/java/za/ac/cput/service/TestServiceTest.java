package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Test;
import za.ac.cput.factory.TestFactory;
import za.ac.cput.service.impl.TestService;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

import static org.junit.jupiter.api.Assertions.*;

class TestServiceTest
{

    private static TestService testService = TestService.getService();
    private static Test createdTest = TestFactory.createTest("AP163","31 October 2022","KNaidoo147","Application Development Paper 1 ,2 hours,09:00 am-11:00am",);

    @Test
    void a_create(){

        Test create = testService.create(createdTest);
        assertEquals(create.getTestId(),createdTest.getTestId());
        System.out.println("ID#1: "+create.getTestId()+"\nID#2"+createdTest.getTestId()+"\n");

    }

    @Test
    void b_read(){
        Test read = testService.read(createdTest.getTestId());
        assertNotNull(read);
        System.out.println("Reading TestID: "+read+"\n");

    }

    @Test
    void c_update(){

        Test updated = new Test.Builder().copy(createdTest).setlectureId("RBurger158").build();
        assertNotNull(courseService.update(updated));

        System.out.println("lecture ID: "+updated.getlectureId()+"\nOld Lecture ID: "+createdTest.getlectureId());

    }

    @Test
    void d_delete(){
        boolean deleted = testService.delete(createdTest.getTetId());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(testService.getAll()+"\n");
    }

}
