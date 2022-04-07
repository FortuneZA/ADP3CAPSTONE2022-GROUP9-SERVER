package za.ac.cput.Factory;
/*
StudentFactoryTest.java
Test for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Student;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest
{
    private String student1;
    private String student2;

    @Test
    public void createStudent() {
        Student student1 = StudentFactory.createStudent("Anele", "Zondo", "anele@gmail.com", "262S");
        Student student2 = StudentFactory.createStudent("Will", "Smith", "thembak@gmail.com", "281J");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        assertNotNull(student1);
        assertNotNull(student2);

    }

    @BeforeEach
    void setUp() {
        Student student1 = StudentFactory.createStudent("Anele", "Zondo", "anele@gmail.com", "262SS");
        Student student2 = StudentFactory.createStudent("Themba", "Khanyile", "thembak@gmail.com", "281J");
    }

    @Test
    void testEquality() {
        assertEquals(student1, student2);

    }

    @Test
    void testIdentity() {

        assertSame(student1, student2);

    }

    @Test
    void testTimeouts() {
        assertTimeout(Duration.ofMillis(2000), () -> {
            Thread.sleep(1000);
        });
    }

    @Disabled
    @Test
    void disableTest() {
        assertEquals(student1, student2);

    }
}
