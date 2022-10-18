package za.ac.cput.factory;
/*
TestFactoryTest.java
Test for TestFactory
Author: Themba Khanyile 217238173
Date : 23 March 2022
 */
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import za.ac.cput.entity.Test;

import java.time.Duration;

public class TestFactoryTest
{
    private Test test1;
    private Test test2;

    @org.junit.jupiter.api.Test
    public void createTest() {
        Test test1 = TestFactory.createTest("RB261","ADP October summative Test","30 October 2022","2 Hours",50);
        Test test2 = TestFactory.createTest("KN331","ITS November final Test","7 November 2022","1.2 hOURS",60);
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        assertNotNull(test1);
        assertNotNull(test2);

    }

    @BeforeEach
    void setup() {
        Test test1 = TestFactory.createTest("RB261","ADP October summative Test","30 October 2022","2 Hours",50);
        Test test2 = TestFactory.createTest("KN331","ITS November final Test","7 November 2022","1.2 hOURS",60);
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
