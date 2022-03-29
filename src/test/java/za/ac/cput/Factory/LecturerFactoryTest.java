package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Lecturer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LecturerFactoryTest {
    Lecturer lecturer1,lecturer2,lecturer3; // object creation

    @BeforeEach
    void setUp() {  // object instantiation
        lecturer1= LecturerFactory.createLecturer("Cameron","Noemdo", "cn@school.com");
        lecturer2= LecturerFactory.createLecturer("John","Doe", "jd@school.com");
        lecturer3=lecturer1;
    }

    @Test
    void testCreation() // test object creation
    {
        assertNotNull(lecturer1);
    }

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

    @Test
    @Disabled
    void disableTest()
    {
        assertNotNull(lecturer3);
        System.out.println("Test successfully disabled");
    }
}
