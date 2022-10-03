package za.ac.cput.repository;

/* LecturerRepositoryTest.java
Test cases for Lecturer Repository
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LecturerRepositoryTest {

    private LecturerRepository lecturerRepository=LecturerRepository.getRepository();
    private Lecturer lecturer= LecturerFactory.createLecturer("Cameron","Henry", "Noemdo","cn@cput.ac.za","0000000");
    private Lecturer lecturer2= LecturerFactory.createLecturer("Susan","W", "Crowley","sc@cput.ac.za","0000001");
    private Lecturer lecturer3= LecturerFactory.createLecturer("William","J", "Junior","wjj@cput.ac.za","0000002");

    private Lecturer lecturerCreated;

    @BeforeEach
    void test()
    {
        System.out.println("---TEST---");
    }

    void createLecturer(Lecturer lec)
    {
        lecturerCreated=lecturerRepository.create(lec);
    }

    @Order(1)
    @Test
    void a_create()
    {
        createLecturer(lecturer3);
        assertEquals(lecturerCreated.getLecturerId(),lecturer3.getLecturerId());
        System.out.println("New Lecturer created: "+lecturerCreated);
    }

    @Order(2)
    @Test
    void b_read()
    {
        createLecturer(lecturer2);
        Lecturer lecturerRead= lecturerRepository.read(lecturerCreated.getLecturerId());
        System.out.println("Lecturer details: "+lecturerRead);
    }

    @Order(3)
    @Test
    void c_update()
    {
        createLecturer(lecturer);
        Lecturer lecturerUpdated=new Lecturer.Builder().copy(lecturer).setFirstName("Johnathan").setLecturerEmail("johnd@school.com").build();
        lecturerUpdated=lecturerRepository.update(lecturerUpdated);
        System.out.println("Old: {ID: "+lecturer.getLecturerId()+", First name: "+lecturer.getFirstName()+", Last name: "+lecturer.getLastName()+", Email: "+lecturer.getLecturerEmail()+"}\n" +
                "New (updated): {ID: "+lecturerUpdated.getLecturerId()+", First name: "+lecturerUpdated.getFirstName()+", Last name: "+lecturerUpdated.getLastName()+", Email: "+lecturerUpdated.getLecturerEmail()+"}");
    }

    @Order(4)
    @Test
    void d_delete()
    {
        createLecturer(lecturer);
        lecturerRepository.delete(lecturerCreated.getLecturerId());
        System.out.println("Deleted: "+lecturerCreated.getLecturerId());
        System.out.println(lecturerRepository.read(lecturerCreated.getLecturerId()));
    }

    @Order(5)
    @Test
    void e_getAll()
    {
        System.out.println("Lecturers: "+lecturerRepository.getAll());
    }
}
