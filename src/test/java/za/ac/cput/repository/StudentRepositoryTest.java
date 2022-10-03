package za.ac.cput.repository;
/*
Student.java
Test for StudentRepository
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class StudentRepositoryTest
{


    private static StudentRepository studentRepository = StudentRepository.getRepository();
    private static Student student = StudentFactory.createStudent("Themba", "Khanyile", "thembak@gmail.com", "281J");
    @Test
    void a_create() {
        Student created = studentRepository.create(student);
        assertEquals(created.getStudentId(), student.getStudentId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {

        Student read = studentRepository.read(student.getStudentId());
        assertNotNull(read);
        System.out.println("Read: " + read );
    }



    @Test
    void c_update() {
        Student updated = new Student.Builder().copy(student).setFirstName("John")
                .setLastName("Doe")
                .setStudentEmail("johndoe@gmail.com")
                .setCourseID("262S")
                .build();
        assertNotNull(studentRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {

        boolean deleted = studentRepository.delete(student.getStudentId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
        d_getAll();

    }

    @Test
    void d_getAll(){
        System.out.println("Show All: " + studentRepository.getAll() + "\n");
    }
}
