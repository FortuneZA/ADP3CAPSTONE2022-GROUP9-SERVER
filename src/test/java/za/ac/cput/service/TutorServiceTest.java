package za.ac.cput.service;
/*
    TutorServiceTest.java
    Author: Devon Daniels (217299822)

 */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Tutor;
import za.ac.cput.factory.TutorFactory;
import za.ac.cput.service.impl.TutorService;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

public class TutorServiceTest {
    TutorService TutorSer =  TutorService.getTutorService();
    Tutor tutor =  TutorFactory.createTutor(" Mike ", "Willie", "Tyson", "MikeTyson@gmail.com", "0381230981");



    @Test
    void create() {
        Tutor create = TutorSer.create(tutor);
        assertEquals(create.toString(), tutor.toString());
        System.out.println("Created: " + create);
    }


    @Test
    void read() {
        Tutor read = TutorSer.read(tutor.toString());
        assertNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Tutor update = TutorSer.update(tutor);
        System.out.println("Update: " + update);
    }

    @Test
    void delete() {
        boolean success = TutorSer.delete(tutor.toString());
        assertFalse(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void getAll() {
        { System.out.println("Get all: " + TutorSer.getAll());
        }

    }
}
