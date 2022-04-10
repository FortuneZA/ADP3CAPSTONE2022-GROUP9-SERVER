/*
 * FacultyFactoryTest.java
 * Test for the FacultyFactory
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Faculty;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {

    private Faculty faculty;
    private Faculty faculty1;
    private Faculty faculty2;


    @Test
     void testObjectCreation(){
        Faculty faculty = FacultyFactory.createFaculty("Informatics and Design","infor@mycput.ac.za");
        System.out.println(faculty.toString());
        assertNotNull(faculty);
    }

    @BeforeEach
    void setUp(){
        faculty = FacultyFactory.createFaculty("Informatics and Design", "infor@mycput.ac.za");
        faculty1 = FacultyFactory.createFaculty("Applied Sciences", "appliedsciences@mycput.ac.za");
        faculty2 = faculty;
    }

    @Test
    void testIdentity(){
        assertSame(faculty2,faculty);
    }

    @Test
    void  testEquality(){
        assertEquals(faculty2,faculty);
    }

    @Test
    void testTimeout(){
        assertTimeout(Duration.ofMillis(3000), ()->{
            Thread.sleep(1000);
        });

    }

    @Disabled
    @Test
    void disableTest(){
        assertEquals(faculty,faculty1);
    }


}