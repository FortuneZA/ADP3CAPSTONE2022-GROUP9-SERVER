package za.ac.cput.factory;

/* LecturerFactoryTest.java
Test class for the Lecturer Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Lecturer;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {
    private final Lecturer lecturer=LecturerFactory.createLecturer("Cameron","Henry", "Noemdo","cn@cput.ac.za","0000000");
    private final Lecturer lecturer2=LecturerFactory.createLecturer("Cameron","Henry", "Noemdo","cncput.ac.za","0000000");

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
        Exception exception=assertThrows(IllegalArgumentException.class,()->lecturer1=LecturerFactory.createLecturer("Cameron","", "Noemdo","cn@cput.ac.za","0000000"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Middle name is not present"));
    }

    @Test
    void testValidEmail() {
        assertTrue(EmailValidator.getInstance().isValid(lecturer.getLecturerEmail()));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(EmailValidator.getInstance().isValid(lecturer2.getLecturerEmail()));
    }
}
