package za.ac.cput.repository;
/*
Student.java
Test for TestRepository
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Test;
import za.ac.cput.factory.TestFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestRepositoryTest
{
    private static Test test = TestFactory.createTest("001","14 February 2022" ,"ADP3 test");
    private TestRepository repository = TestRepository.getRepository();




    @org.junit.jupiter.api.Test
    public void a_create() {
        Test inserted = repository.create(test);
        assertEquals(inserted.getTestId(), test.getTestId());
        System.out.println("Create: " + inserted);
    }

    @org.junit.jupiter.api.Test
    public void b_read() {
        Test read = repository.read(test.getTestId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }
    @org.junit.jupiter.api.Test
    public void c_update() {
        Test updated = new Test.Builder().copy(test).setLecturerId("005")
                .setTestDate("18 March 2022")
                .setTestInfo("Project Management Paper 2")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }


    @org.junit.jupiter.api.Test
    public void e_delete() {
        boolean deleted = repository.delete(test.getTestId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);

    }

    @org.junit.jupiter.api.Test
    public void d_getAll(){
        System.out.println("Show All"+ repository.getAll());
    }
}
