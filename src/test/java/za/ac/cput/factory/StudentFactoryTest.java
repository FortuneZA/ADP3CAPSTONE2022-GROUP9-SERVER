package za.ac.cput.factory;
/*
StudentFactoryTest.java
Test for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
import static org.junit.jupiter.api.Assertions.*;


import com.sun.xml.bind.v2.runtime.unmarshaller.WildcardLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Student;

import java.time.Duration;

public class StudentFactoryTest
{
    private String student1;
    private String student2;

    @Test
    public void createStudent() {
        Student student1 = StudentFactory.createStudent("will","saul","smith","will@cput.ac.za","262S");
        Student student2 = StudentFactory.createStudent("amanda","dudu","khoza","amanda@cput.ac.za","15KP");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        assertNotNull(student1);
        assertNotNull(student2);

    }

    @BeforeEach
    void setUp() {
        Student student1 = StudentFactory.createStudent("will","saul","smith","will@cput.ac.za","262S");
        Student student2 = StudentFactory.createStudent("amanda","dudu","khoza","amanda@cput.ac.za","15KP");
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

