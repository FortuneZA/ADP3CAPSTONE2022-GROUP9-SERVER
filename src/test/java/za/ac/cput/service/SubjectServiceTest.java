package za.ac.cput.service;
/*
SubjectServiceTest.java
Test cases for SubjectService
Author: Mathew Fortuin (219069514)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class SubjectServiceTest {

    private static SubjectService subjectService;
    private static Subject createdSubject = SubjectFactory.createSubject("ITS045","Information Systems 4",36,"AW12");

    @Test
    void a_create(){

        Subject create = subjectService.create(createdSubject);
        assertEquals(create.getSubjectID(),createdSubject.getSubjectID());
        System.out.println("ID#1: "+create.getSubjectID()+"\nID#2"+createdSubject.getSubjectID()+"\n");

    }

    @Test
    void b_read(){
        Subject read = subjectService.read(createdSubject.getSubjectID());
        assertNotNull(read);
        System.out.println("Reading SubjectID: "+read+"\n");

    }

    @Test
    void c_update(){

        Subject updated = new Subject.Builder().copy(createdSubject).setLecturerID("KB012").build();
        assertNotNull(subjectService.update(updated));

        System.out.println("Current Lecturer ID: "+updated.getLecturerID()+"\nOld Lecturer ID: "+createdSubject.getLecturerID());

    }

    @Test
    void d_delete(){
        boolean deleted = subjectService.delete(createdSubject.getSubjectID());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_getAll();
    }

    @Test
    void e_getAll() {

        System.out.println(subjectService.getAll()+"\n");
    }

}