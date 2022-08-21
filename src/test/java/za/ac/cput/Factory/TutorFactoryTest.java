package za.ac.cput.Factory;
/*
        TutorFactoryTest.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Tutor;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class TutorFactoryTest {

    //object creation
    @Test
    public void test()
    {
        Tutor tutor =  TutorFactory.createTutor("Will ", "Bel-Air ", "Smith", "WillS@gmail.com", "0219876541");

        assertNotNull(tutor.toString());
        System.out.println(tutor);
    }
}