package za.ac.cput.service;

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

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest 
{

   private static CourseService courseService = CourseService.getService();
    private static Course createdCourse = CourseFactory.createCourse("217238173","Themba","Khanyile","217238173@mycput.ac.za","IT02");

    @Test
    void a_create(){

        Student create = studentService.create(studentCourse);
        assertEquals(create.getStudentId(),createdStudent.getStudentId());
        System.out.println("ID#1: "+create.getStudentId()+"\nID#2"+createdStudent.getStudentId()+"\n");

    }

    @Test
    void b_read(){
        Student read = studentService.read(createdStudent.getStudentId());
        assertNotNull(read);
        System.out.println("Reading CourseID: "+read+"\n");

    }

    @Test
    void c_update(){

        Student updated = new Student.Builder().copy(createdStudent).setDepartmentId("IT30").build();
        assertNotNull(studentService.update(updated));

       
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
