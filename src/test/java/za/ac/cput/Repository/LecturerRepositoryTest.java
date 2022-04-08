package za.ac.cput.Repository;

/* LecturerRepositoryTest.java
Test cases for Lecturer Repository
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Factory.LecturerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LecturerRepositoryTest {

    private LecturerRepository lecturerRepository=LecturerRepository.getRepository();
    private Lecturer lecturer= LecturerFactory.createLecturer("John","Doe","jd@school.com");
    private Lecturer lecturer2= LecturerFactory.createLecturer("Susan","Crowley","scrowley@school.com");
    private Lecturer lecturer3= LecturerFactory.createLecturer("William","Junior","willjunior@school.com");

    private Lecturer lecturerCreated;

    @BeforeEach
    void test()
    {
        System.out.println("---TEST---");
    }

    @Order(1)
    @Test
    void a_create()
    {
        lecturerCreated=lecturerRepository.create(lecturer3);
        assertEquals(lecturerCreated.getLecturerID(),lecturer3.getLecturerID());
        System.out.println("New Lecturer created: "+lecturerCreated);
    }

    @Order(2)
    @Test
    void b_read() // test reads null when it shouldn't. FIX!!!
    {
        lecturerCreated=lecturerRepository.create(lecturer2);
        Lecturer lecturerRead= lecturerRepository.read(lecturerCreated.getLecturerID());
        System.out.println("Lecturer details: "+lecturerRead);
    }

    @Order(3)
    @Test
    void c_update()
    {
        lecturerCreated=lecturerRepository.create(lecturer);
        Lecturer lecturerUpdated=new Lecturer.Builder().copy(lecturer).setFirstName("Johnathan").setLecturerEmail("johnd@school.com").build();
        lecturerUpdated=lecturerRepository.update(lecturerUpdated);
        System.out.println("Old: {ID: "+lecturer.getLecturerID()+", First name: "+lecturer.getFirstName()+", Last name: "+lecturer.getLastName()+", Email: "+lecturer.getLecturerEmail()+"}\n" +
                "New (updated): {ID: "+lecturerUpdated.getLecturerID()+", First name: "+lecturerUpdated.getFirstName()+", Last name: "+lecturerUpdated.getLastName()+", Email: "+lecturerUpdated.getLecturerEmail()+"}");
    }

    @Order(4)
    @Test
    void d_delete()
    {
        lecturerCreated=lecturerRepository.create(lecturer);
        lecturerRepository.delete(lecturerCreated.getLecturerID());
        System.out.println("Deleted: "+lecturerCreated.getLecturerID());
        System.out.println(lecturerRepository.read(lecturerCreated.getLecturerID()));
    }

    @Order(5)
    @Test
    void e_getAll()
    {
        System.out.println("Lecturers: "+lecturerRepository.getAll());
    }
}
