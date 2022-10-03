/*
 * FacultyFactoryTest.java
 * Test for the FacultyFactory
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.factory;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Faculty;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {
    List<String> departmentList = Arrays.asList("Information Technology","Applied Design","Media");
    private final Faculty faculty = FacultyFactory.createFaculty("Informatics and Design",departmentList);
    private Faculty faculty1;

    @Order(1)
    @Test
    void buildFacultyFactoryWithSuccess(){
        System.out.println(departmentList);
        assertAll(
                ()->assertNotNull(faculty),
                ()-> assertEquals("Informatics and Design",faculty.getFacultyName())
        );
    }

    @Order(2)
    @Test
    void buildFacultyFactoryWithEmptyName(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                faculty1 = FacultyFactory.createFaculty("",departmentList));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide faculty name ",exceptionMessage);
    }

//    @Order(3)
//    @Test
//    void buildFacultyWith
}