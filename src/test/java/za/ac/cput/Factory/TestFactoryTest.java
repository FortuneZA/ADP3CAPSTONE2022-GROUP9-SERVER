package za.ac.cput.Factory;
/*
TestFactoryTest.java
Test for TestFactory
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import za.ac.cput.Entity.Test;

import java.time.Duration;

public class TestFactoryTest
{
    private Test test1;
    private Test test2;

    @org.junit.jupiter.api.Test
    public void createTest() {
        Test test1 = TestFactory.createTest("0024", "20 March 2022", "ADP3 test");
        Test test2 = TestFactory.createTest("0025", "4 April 2022", "Project Management test");

        System.out.println(test1.toString());
        System.out.println(test2.toString());
        assertNotNull(test1);
        assertNotNull(test2);

    }

    @BeforeEach
    void setup() {
        Test test1 = TestFactory.createTest("0024", "20 March 2022", "ADP3 test");
        Test test2 = TestFactory.createTest("0025", "4 April 2022", "Project Managementtest");
    }


    @org.junit.jupiter.api.Test
    void testEquality() {
        assertEquals(test1, test2);
    }

    @org.junit.jupiter.api.Test
    void testIdentity() {
        assertSame(test1, test2);
    }

    @org.junit.jupiter.api.Test
    void testTimeouts() {
        assertTimeout(Duration.ofMillis(2000), () -> {
            Thread.sleep(1000);
        });
    }

    @Disabled
    @org.junit.jupiter.api.Test
    void disableTest() {
        assertEquals(test1, test2);

    }
}
