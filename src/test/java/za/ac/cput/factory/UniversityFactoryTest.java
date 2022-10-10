package za.ac.cput.factory;

/* UniversityFactoryTest.java
Test class for the University Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.University;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityFactoryTest {
    private final University university=UniversityFactory.createUniversity("CPUT", "cput@cput.ac.za");
    University university2;


    @Test
    void successCreateUniversity() {
        assertAll(
                () -> assertNotNull(university),
                () -> assertEquals("CPUT",university.getUniversityName())
        );
        System.out.println(university);
    }

    @Test
    void failCreateUniversity() {
        Exception ex=assertThrows(IllegalArgumentException.class, ()->university2=UniversityFactory.createUniversity("", "cput.@cput.ac.za"));
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("University name"));
    }

    @Test
    void testValidEmail() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->university2=UniversityFactory.createUniversity("CPUT","cputcput.ac.za"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));
    }
}
