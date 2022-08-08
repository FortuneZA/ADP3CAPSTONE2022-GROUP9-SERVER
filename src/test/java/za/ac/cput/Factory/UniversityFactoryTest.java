package za.ac.cput.Factory;

/* UniversityFactoryTest.java
Test class for the University Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.University;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityFactoryTest {
    List<String> list= Arrays.asList("Applied Science", "Informatics and Design", "Education");

    private final University university=UniversityFactory.createUniversity("CPUT", "cput@cput.ac.za", list);
    private final University university1=UniversityFactory.createUniversity("CPUT", "cputcput.ac.za", list);
    private University university2;

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
        Exception ex=assertThrows(IllegalArgumentException.class, ()->university2=UniversityFactory.createUniversity("", "cput@cput.ac.za", list));
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("University name"));
    }

    @Test
    void testValidEmail() {
        assertTrue(EmailValidator.getInstance().isValid(university.getEmail()));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(EmailValidator.getInstance().isValid(university1.getEmail()));
    }
}
