package za.ac.cput.service;
/*
        EnrollmentService.java
        Author: Devon Daniels (217299822)

        */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Enrollment;
import za.ac.cput.factory.EnrollmentFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {
    EnrollmentService EnrollmentSer =  EnrollmentService.getEnrollmentService();
    Enrollment enrollment =  EnrollmentFactory.createEnrollment(" Enrollment V3.pdf ",    "24 February 2023");



    @Test
    void create() {
        Enrollment create = EnrollmentSer.create(enrollment);
        assertEquals(create.toString(), enrollment.toString());
        System.out.println("Created: " + create);
    }


    @Test
    void read() {
        Enrollment read = EnrollmentSer.read(enrollment.toString());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Enrollment update = EnrollmentSer.update(enrollment);
        System.out.println("Update: " + update);
    }

    @Test
    void delete() {
        boolean success = EnrollmentSer.delete(enrollment.toString());
        assertFalse(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll() {
        { System.out.println("Get all: " + EnrollmentSer.getAll());
        }

    }
}