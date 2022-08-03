package za.ac.cput.Factory;

/* UniversityFactoryTest.java
Test class for the University Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.University;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityFactoryTest {
    private final University university=UniversityFactory.createUniversity("CPUT", "Cape Town", "District Six","0211324567");
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
        Exception ex=assertThrows(IllegalArgumentException.class, ()->university2=UniversityFactory.createUniversity("", "Cape Town", "District Six","0211324567"));
        System.out.println(ex.getMessage());
        assertTrue(ex.getMessage().contains("University name"));
    }

    @Test
    void testValidPhoneNumber() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->university2=UniversityFactory.createUniversity("CPUT", "Cape Town", "District Six","02113245675987"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid phone number length provided"));
    }
}
