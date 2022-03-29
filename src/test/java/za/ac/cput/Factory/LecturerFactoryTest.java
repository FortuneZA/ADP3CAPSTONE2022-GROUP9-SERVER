package za.ac.cput.Factory;

/* LecturerFactoryTest.java
Test class for the Lecturer Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Lecturer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {
    Lecturer lecturer1,lecturer2,lecturer3,test; // object creation

    @BeforeEach
    void setUp() {  // object instantiation
        lecturer1= LecturerFactory.createLecturer("Cameron","Noemdo", "cn@school.com");
        lecturer2= LecturerFactory.createLecturer("John","Doe", "jd@school.com");
        lecturer3=lecturer1;
        test=LecturerFactory.createLecturer("J","D","jdschool.com"); // NOTE: Incorrect email address format
    }

    @Test
    void testObjectCreation() // test object creation
    {
        assertNotNull(lecturer1);
    }

    @Test
    void testCreateLecturer()
    {
        assertNotNull(lecturer1.getLecturerID());
        assertEquals("Cameron",lecturer1.getFirstName());
        assertEquals("Noemdo",lecturer1.getLastName());
        assertEquals("cn@school.com",lecturer1.getLecturerEmail());
    }

//    @Disabled("Test disabled as it will fail (Correct outcome).")
//    @Test
//    void testEmailFail()
//    {
//        assertTrue(EmailValidator.getInstance().isValid(test.getLecturerEmail()));
//    }
//
//    @Test
//    void testEmailPass()
//    {
//        assertTrue(EmailValidator.getInstance().isValid(lecturer1.getLecturerEmail()));
//    }

    @Test
    void testObjectIdentity()
    {
        assertSame(lecturer1,lecturer3);
        System.out.println("Objects are identical");
    }

    @Test
    void testObjectEquality()
    {
        assertEquals(lecturer1,lecturer3);
        System.out.println("Objects are equal");
    }

    @Test
    void timeoutTest()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(1);
            assertNotEquals(lecturer1,lecturer2);
            System.out.println("Timeout test PASSED");
        }
        catch(InterruptedException iEx)
        {
            System.out.println("Exception: "+iEx.getMessage());
            System.out.println("Test timed out");
        }
    }
}
