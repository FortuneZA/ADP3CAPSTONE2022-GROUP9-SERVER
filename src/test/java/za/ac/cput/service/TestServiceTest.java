package za.ac.cput.service;
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
import za.ac.cput.entity.TestModel;
import za.ac.cput.factory.TestModelFactory;
import za.ac.cput.service.impl.TestModelService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class TestModelServiceTest {


    private final TestModel test = TestModelFactory.createTest("QWE782", "INM-Sick-Test", "2 November 2022", "4 Hours", 30);
    private TestModel testModelCreated;

    @Autowired
    private TestModelService testModelService;

    void createTest(TestModel testModel) {
        testModelCreated = testModelService.create(testModel);
    }

    @Test
    void d_getAll() {
        Set<TestModel> testModelSet = testModelService.getAll();
        System.out.println(testModelSet);
    }

    @Test
    void a_create() {
        new TestModel(test);
        assertEquals("QWE782",testModelCreated.getSubjectId());
        System.out.println("Created: " + testModelCreated);
    }

    @Test
    void b_read() {
        createTest(test);
        TestModel testModelRead= testModelService.read(testModelCreated.getTestId());
        System.out.println("Read: " + testModelRead);
    }

    @Test
    void c_update() {
        createTest(test);
        TestModel testUpdate = new TestModel
                .Builder()
                .copy(test)
                .setTestId("HuaMui")
                .setSubjectId("MUD785")
                .setTestName("Multimedia Practical Test")
                .setTestDate("30 October 2022")
                .setDuration("1 Hour")
                .setResultInPercent(50)
                .build();
        testModelService.update(testUpdate);
        System.out.println("Updated: " + testUpdate);
    }

    @Test
    void e_delete() {
        createTest(test);
        boolean delete = testModelService.delete(test.getTestId());
        assertTrue(delete);
    }

}
