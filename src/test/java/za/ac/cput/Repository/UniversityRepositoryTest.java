package za.ac.cput.Repository;

/* UniversityRepositoryTest.java
Test cases for University Repository
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.University;
import za.ac.cput.Factory.UniversityFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityRepositoryTest {
    List<String> list1= Arrays.asList("Applied Science", "Informatics and Design", "Education");
    List<String> list2= Arrays.asList("Education");
    List<String> list3= Arrays.asList("Applied Science", "Informatics and Design", "Engineering and the Built Environment", "Education");


    private UniversityRepository universityRepository=UniversityRepository.getRepository();

    private University university= UniversityFactory.createUniversity("CPUT", "cput@cput.ac.za", list1);
    private University university2= UniversityFactory.createUniversity("UWC", "uwc@wc.ac.za", list2);
    private University university3= UniversityFactory.createUniversity("UCT", "uct@ct.org", list3);

    private University universityCreated;

    @BeforeEach
    void test()
    {
        System.out.println("---TEST---");
    }

    void createUniversity(University uni)
    {
        universityCreated=universityRepository.create(uni);
    }

    @Order(1)
    @Test
    void a_create()
    {
        createUniversity(university3);
        assertEquals(universityCreated.getUniversityId(),university3.getUniversityId());
        System.out.println("New University created: "+universityCreated);
    }

    @Order(2)
    @Test
    void b_read()
    {
        createUniversity(university2);
        University universityRead= universityRepository.read(universityCreated.getUniversityId());
        System.out.println("University details: "+universityRead);
    }

    @Order(3)
    @Test
    void c_update()
    {
        createUniversity(university);
        University universityUpdated=new University.Builder().copy(university).setEmail("cput@cput.com").build();
        universityUpdated=universityRepository.update(universityUpdated);
        System.out.println("Old: {ID: "+university.getUniversityId()+", Name: "+university.getUniversityName()+", Email: "+university.getEmail()+", Faculties: "+university.getFacultyList()+"}" +
                "\nNew: {ID: "+universityUpdated.getUniversityId()+", Name: "+universityUpdated.getUniversityName()+", Email: "+universityUpdated.getEmail()+", Faculties: "+universityUpdated.getFacultyList()+"}");
    }

    @Order(4)
    @Test
    void d_delete()
    {
        createUniversity(university);
        universityRepository.delete(university.getUniversityId());
        System.out.println("Deleted: "+university.getUniversityId());
        System.out.println(universityRepository.read(university.getUniversityId()));
    }

    @Order(5)
    @Test
    void e_getAll()
    {
        System.out.println("Universities: "+universityRepository.getAll());
    }
}
