package za.ac.cput.Factory;
/*
        EnrollmentFactoryTest.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Enrollment;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class EnrollmentFactoryTest {

    //object creation
    @Test
    public void test()
    {
        Enrollment enrollment =  EnrollmentFactory.createEnrollment("Enrollment.pdf", "24 February 2023 ");

        assertNotNull(enrollment.toString());
        System.out.println(enrollment);
    }
}