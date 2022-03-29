package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.University;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityFactoryTest {
    University university1,university2,university3; // objects declaration

    @BeforeEach
    void setUp() { // objects instantiation
        university1=UniversityFactory.createUniversity("CPUT", "Cape Town", "District Six","021132456789");
        university2=UniversityFactory.createUniversity("UWC", "Cape Town", "Bellville","+27984164181");
        university3=university1;
    }

    @Test
    void testCreation() // test object creation
    {
        assertNotNull(university1);
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

    @Test
    @Disabled
    void disableTest()
    {
        assertNotNull(university3);
        System.out.println("Test successfully disabled");
    }
}
