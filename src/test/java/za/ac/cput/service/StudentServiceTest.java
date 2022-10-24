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
import za.ac.cput.entity.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.service.impl.StudentService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class StudentServiceTest {


    private final Student student = StudentFactory.createStudent("John","Doe","smith","johndoe@cput.ac.za","268RS");
    private Student studentCreated;

    @Autowired
    private StudentService studentService;

    void createStudent(Student stud )
    {
        studentCreated=studentService.create(stud);
    }

    @Test
    void d_getAll()
    {
        Set<Student> studentSet=studentService.getAll();
        System.out.println(studentSet);
    }

    @Test
    void a_create()
    {
        createStudent(student);
        assertEquals("John",studentCreated.getFirstName());
        System.out.println("Created: "+studentCreated);
    }

    @Test
    void b_read()
    {
        createStudent(student);
        Student studentRead= studentService.read(studentCreated.getStudentId());
        System.out.println("Read: "+studentRead);
    }

    @Test
    void c_update()
    {
        createStudent(student);
        Student studentUpdate=new Student
                .Builder()
                .copy(student)
                .setFirstName("Themba")
                .setMiddleName("Kha")
                .setLastName("Zilla")
                .setStudentEmail("tkz@cput.ac.za")
                .setCourseID("369RT")
                .build();
        studentService.update(studentUpdate);
        System.out.println("Updated: "+studentUpdate);
    }

    @Test
    void e_delete()
    {
        createStudent(student);
        boolean delete=studentService.delete(student.getStudentId());
        assertTrue(delete);
    }


}
