/*
package za.ac.cput.service;
/*FacultyService.java test cases
Author: Mawande Langa (219074054)
Date: 09/10/2022

 
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Course;
import za.ac.cput.entity.Department;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;
import za.ac.cput.service.impl.FacultyService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class FacultyServiceTest {
    private FacultyService facultyService = FacultyService.getFacultyService();

   private static List<String> departmentList = Arrays.asList("Information Technology","Applied Design","Media");

    private static Faculty  createFaculty = FacultyFactory.createFaculty("Business",departmentList);

    @Test
    void a_create(){
        Faculty create = facultyService.create(createFaculty);
        assertEquals(create.getFacultyID(),createFaculty.getFacultyID());
        System.out.println("Created: "+ create);
    }

    @Test
    void b_read(){
        Faculty read = facultyService.read(createFaculty.getFacultyID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update(){
        Faculty update = new Faculty.Builder().copy(createFaculty).setFacultyID("229074054").setFacultyName("Business").setDepartmentList(departmentList).build();
        assertNotNull(update);
        System.out.println("Updated: " + update);

    }

@Test
    void d_delete(){
        boolean delete = facultyService.delete(createFaculty.getFacultyID());
        assertTrue(delete);
    System.out.println("Deleted: "+ delete);
    e_getAll();
}

@Test
    void e_getAll(){
    System.out.println(facultyService.getAll());
}

}
*/
