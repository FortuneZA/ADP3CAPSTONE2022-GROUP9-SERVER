package za.ac.cput.repository;
/*
        EnrollmentRepositoryTest.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Enrollment;
import za.ac.cput.factory.EnrollmentFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EnrollmentRepositoryTest {

    private static EnrollmentRepository enrollmentRepository= EnrollmentRepository.getRepository();
    private static Enrollment enrollment = EnrollmentFactory.createEnrollment("Enrollment.pdf", "24 Februaury");


    @Test
    void a_create() {

        Enrollment created =         enrollmentRepository.create(enrollment);
        assertEquals(created.getEnrollmentID(), enrollment.getEnrollmentID());
        System.out.println("Created ID: " + created.getEnrollmentID()+ "\nEnrollment ID: " + enrollment.getEnrollmentID() + "\n");
    }

    @Test
    void b_read() {

        Enrollment read = enrollmentRepository.read(enrollment.getEnrollmentID());
        assertNotNull(read);
        System.out.println("Read: " + read + "\n");
    }
    @Test
    void c_update() {

        Enrollment updated = new Enrollment.Builder().copy(enrollment).setEnrollmentDetails("Enrollment V2.pdf").setEnrollmentDates("27 March 2023").build();
        assertNotNull(enrollmentRepository.update(updated));
        System.out.println("Updated (" + updated.getEnrollmentID() + "): " + updated.getEnrollmentDetails() + " " + updated.getEnrollmentDates());
    }



    @Test
    void e_delete() {

        boolean deleted = enrollmentRepository.delete(enrollment.getEnrollmentID());
        //assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {

        System.out.println("\nDisplay all :" );
        System.out.println(enrollmentRepository.getAll() + "\n");
    }
}
