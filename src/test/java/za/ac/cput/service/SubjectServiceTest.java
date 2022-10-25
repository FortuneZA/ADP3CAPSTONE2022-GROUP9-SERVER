package za.ac.cput.service;
/*
SubjectServiceTest.java
Test cases for SubjectService
Author: Mathew Fortuin (219069514)
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;
import za.ac.cput.service.impl.SubjectService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SubjectServiceTest {
    private final Subject subject= SubjectFactory.createSubject("Accounting",36,"KB83");

    private Subject subjectCreated;

    @Autowired
    private SubjectService subjectService;

    void createSubject(Subject sub) {
        subjectCreated=subjectService.create(sub);
    }

    @Test
    void d_getAll()
    {
        Set<Subject> subjectSet=subjectService.getAll();
        System.out.println(subjectSet);
    }

    @Test
    void a_create()
    {
        createSubject(subject);
        assertEquals("ICT:Applications Development",subjectCreated.getSubjectName());
        System.out.println("Created: "+subjectCreated);
    }

    @Test
    void b_read()
    {
        createSubject(subject);
        Subject subjectRead= subjectService.read(subjectCreated.getSubjectID());
        System.out.println("Read: "+subjectRead);
    }

    @Test
    void c_update()
    {
        createSubject(subject);
        Subject subjectUpdate=new Subject
                .Builder()
                .copy(subject)
                .setLecturerID("KB74")
                .build();
        subjectService.update(subjectUpdate);
        System.out.println("Updated: "+subjectUpdate);
    }

    @Test
    void e_delete()
    {
        createSubject(subject);
        boolean delete=subjectService.delete(subject.getSubjectID());
        assertTrue(delete);
    }



}