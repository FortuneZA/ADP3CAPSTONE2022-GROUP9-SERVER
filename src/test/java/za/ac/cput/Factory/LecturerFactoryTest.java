package za.ac.cput.Factory;

/* LecturerFactoryTest.java
Test class for the Lecturer Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Lecturer;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {
    private final Lecturer lecturer=LecturerFactory.createLecturer("Cameron","Noemdo", "cn@school.com");

    private Lecturer lecturer1;

    @Test
    void successCreateLecturer() {
        assertAll(
                ()->assertNotNull(lecturer),
                ()->assertEquals("Cameron",lecturer.getFirstName())
        );
    }

    @Test
    void failCreateLecturer() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->lecturer1=LecturerFactory.createLecturer("Cameron","", "cn@school.com"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Last name is not present"));
    }

    @Test
    void testValidEmail() {
        Exception exception=assertThrows(IllegalArgumentException.class,()->lecturer1=LecturerFactory.createLecturer("Cameron","Noemdo", "cnschool.com"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid email"));
    }
}
