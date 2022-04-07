package za.ac.cput.Repository;

/* UniversityRepositoryTest.java
Test cases for University Repository
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.University;
import za.ac.cput.Factory.UniversityFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityRepositoryTest {

    private UniversityRepository universityRepository=UniversityRepository.getRepository();

    private University university= UniversityFactory.createUniversity("CPUT","Cape Town","Cape Town","+27123456789");
    private University university2= UniversityFactory.createUniversity("UWC","Cape Town","Cape Town","0219777888");
    private University university3= UniversityFactory.createUniversity("UCT","Cape Town","Cape Town","+27215698135");

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
        assertEquals(universityCreated.getUniversityID(),university3.getUniversityID());
        System.out.println("New University created: "+universityCreated);
    }

    @Order(2)
    @Test
    void b_read()
    {
        createUniversity(university2);
        University universityRead= universityRepository.read(universityCreated.getUniversityID());
        System.out.println("University details: "+universityRead);
    }

    @Order(3)
    @Test
    void c_update()
    {
        createUniversity(university);
        University universityUpdated=new University.Builder().copy(university).setAddress("Bellville").setPhoneNumber("0219876543").build();
        universityUpdated=universityRepository.update(universityUpdated);
        System.out.println("Old: {ID: "+university.getUniversityID()+", Name: "+university.getUniversityName()+", City: "+university.getCity()+", Address: "+university.getAddress()+", Phone number: "+university.getPhoneNumber()+"}" +
                "\nNew: {ID: "+universityUpdated.getUniversityID()+", Name: "+universityUpdated.getUniversityName()+", City: "+universityUpdated.getCity()+", Address: "+universityUpdated.getAddress()+", Phone number: "+universityUpdated.getPhoneNumber()+"}");
    }

    @Order(4)
    @Test
    void d_delete()
    {
        createUniversity(university);
        universityRepository.delete(university.getUniversityID());
        System.out.println("Deleted: "+university.getUniversityID());
        System.out.println(universityRepository.read(university.getUniversityID()));
    }

    @Order(5)
    @Test
    void e_getAll()
    {
        System.out.println("Universities: "+universityRepository.getAll()+"\n");
    }
}
