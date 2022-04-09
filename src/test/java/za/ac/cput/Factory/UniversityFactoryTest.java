package za.ac.cput.Factory;

/* UniversityFactoryTest.java
Test class for the University Factory
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.University;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityFactoryTest {
    University university1,university2,university3,test,test2; // objects declaration

    @BeforeEach
    void setUp() { // objects instantiation
        university1=UniversityFactory.createUniversity("CPUT", "Cape Town", "District Six","021132456789");
        university2=UniversityFactory.createUniversity("UWC", "Cape Town", "Bellville","+27984164181");
        university3=university1;
        test=UniversityFactory.createUniversity("UCT","Cape Town","Cape Town","021 538 948"); // NOTE: incorrect phone number length
        test2=UniversityFactory.createUniversity("CPUT","Cape Town","Wellington",""); // NOTE: no phone number
        System.out.println("---TEST---");
    }

    @Test
    void testObjectCreation() // test object creation
    {
        assertNotNull(university1);
    }

    @Test
    void testCreateUniversity()
    {
        assertNotNull(university1.getUniversityID());
        assertEquals("CPUT",university1.getUniversityName());
        assertEquals("Cape Town",university1.getCity());
        assertEquals("District Six",university1.getAddress());
        assertEquals("021132456789",university1.getPhoneNumber());
    }

    @Disabled("Test disabled as it will fail (Correct outcome).")
    @Test
    void testFailCreateUniversity() // Test for incorrect/correct phone number length
    {
        assertNotNull(test.getUniversityID());
        assertEquals("UCT",test.getUniversityName());
        assertEquals("Cape Town",test.getCity());
        assertEquals("Cape Town",test.getAddress());
        assertEquals("021 538 948",test.getPhoneNumber()); // length is still 9 after replacing whitespaces with no space. with spaces, length is 11 which would have been acceptable if not for the regex
    }

    @Disabled("Test disabled as it will fail (Correct outcome).")
    @Test
    void testFailCreateUniversity2() // Test for missing phone number
    {
        assertNotNull(test2.getUniversityID());
        assertEquals("UCT",test2.getUniversityName());
        assertEquals("Cape Town",test2.getCity());
        assertEquals("Wellington",test2.getAddress());
        assertEquals("",test2.getPhoneNumber());
    }

    @Test
    void testPhoneNumberShallowCopy()
    {
        assertEquals("021132456789",university3.getPhoneNumber());
    }

    @Test
    void testObjectIdentity()
    {
        assertSame(university1,university3);
        System.out.println("Objects are identical");
    }

    @Test
    void testObjectEquality()
    {
        assertEquals(university1,university3);
        System.out.println("Objects are equal");
    }

    @Test
    void timeoutTest()
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(1);
            assertNotEquals(university1,university2);
            System.out.println("Timeout test PASSED");
        }
        catch(InterruptedException iEx)
        {
            System.out.println("Exception: "+iEx.getMessage());
            System.out.println("Test timed out");
        }
    }
}
