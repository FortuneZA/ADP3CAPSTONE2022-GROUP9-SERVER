package za.ac.cput.service;
/*

 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.University;
import za.ac.cput.factory.UniversityFactory;
import za.ac.cput.service.impl.UniversityService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class UniversityServiceTest {

    private final University university= UniversityFactory.createUniversity("CPUT", "cput@cput.ac.za");

    private University universityCreated;

    @Autowired
    private UniversityService universityService;

    void createUniversity(University uni){
        universityCreated=universityService.create(uni);
    }


    @Test
    public void d_getAll() {
        Set<University> universitySet=universityService.getAll();
        System.out.println(universitySet);
    }

    @Test
    public void a_create() {
        createUniversity(university);
        assertEquals("CPUT",universityCreated.getUniversityName());
        System.out.println("Created: "+universityCreated);
    }

    @Test
    public void b_read() {
        createUniversity(university);
        University universityRead=universityService.read(universityCreated.getUniversityId());
        System.out.println("Read: "+universityRead);
    }

    @Test
    public void c_update() {
        createUniversity(university);
        University universityUpdate=new University.Builder()
                .copy(university)
                .setEmail("cput@edu.co.za")
                .build();
        universityService.update(universityUpdate);
        System.out.println("Updated: "+universityUpdate);
    }

    @Test
    public void e_delete() {
        createUniversity(university);
        boolean delete=universityService.delete(universityCreated.getUniversityId());
        assertTrue(delete);
    }
}