package za.ac.cput.service;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.impl.StudentService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class StudentServiceTest {

    private static StudentService studentService = StudentService.getService();
    private static Student createdStudent = StudentFactory.createStudent("John","Doe","johndoe@cput.ac.za","ADT262S");

    @Test
    void a_create(){

        Student create = studentService.create(createdStudent);
        assertEquals(create.getStudentId(),createdStudent.getStudentId());
        System.out.println("ID#1: "+create.getStudentId()+"\nID#2"+createdStudent.getStudentId()+"\n");

    }

    @Test
    void b_read(){
        Student read = studentService.read(createdStudent.getStudentId());
        assertNotNull(read);
        System.out.println("Reading StudentID: "+read+"\n");

    }

    @Test
    void c_update(){

        Student updated = new Student.Builder().copy(createdStudent).setCourseID("IT30").build();
        assertNotNull(studentService.update(updated));

        System.out.println("Current course ID: "+updated.getCourseID()+"\nOld course ID: "+createdStudent.getCourseID());

    }

    @Test
    void d_delete(){
        boolean deleted = studentService.delete(createdStudent.getStudentId());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(studentService.getAll()+"\n");
    }

}