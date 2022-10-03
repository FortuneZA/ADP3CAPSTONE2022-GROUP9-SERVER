package za.ac.cput.repository;
/*
        TutorRepositoryTest.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TutorRepositoryTest {

    private static TutorRepository tutorRepository= TutorRepository.getRepository();
    private static Tutor tutor = TutorFactory.createTutor("Martin", "Big-Mama", "Lawrence", "Martin@gmail.com","0213456789");


    @Test
    void a_create() {

        Tutor created =         tutorRepository.create(tutor);
        assertEquals(created.getTutorID(), tutor.getTutorID());
        System.out.println("Created ID: " + created.getTutorID()+ "\nTutor ID: " + tutor.getTutorID() + "\n");
    }

    @Test
    void b_read() {

        Tutor read = tutorRepository.read(tutor.getTutorID());
        assertNotNull(read);
        System.out.println("Read: " + read + "\n");
    }

    @Test
    void c_update() {

        Tutor updated = new Tutor.Builder().copy(tutor).setFirstName("Joseph").setMiddleName("Judy").setLastName("Davids ").setTutorEmail("JosephJ@gmail.com").setTutorPhoneNumber("0831247890").build();
        assertNotNull(tutorRepository.update(updated));
        System.out.println("Updated (" + updated.getTutorID() + "): " + updated.getFirstName() + " " + updated.getMiddleName()+ " "
                + updated.getLastName()+ " " + updated.getTutorEmail() + " " + updated.getTutorPhoneNumber());
    }



    @Test
    void e_delete() {

        boolean deleted = tutorRepository.delete(tutor.getTutorID());
        //assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {

        System.out.println("\nDisplay all :" );
        System.out.println(tutorRepository.getAll() + "\n");
    }
}
