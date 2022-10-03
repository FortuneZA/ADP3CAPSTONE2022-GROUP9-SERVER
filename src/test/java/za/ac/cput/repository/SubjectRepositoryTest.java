package za.ac.cput.repository;
/*
SubjectRepositoryTest.java
Repository Test cases for Subject
Author: Mathew Fortuin - 219069514
Date: 8/4/2022
 */


import org.junit.jupiter.api.*;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class SubjectRepositoryTest {

    private SubjectRepository subjectRepo = SubjectRepository.getRepository();

    private Subject subject = SubjectFactory.createSubject("AD12", "Architecture Design", 36, "AKW");
    private Subject subject2 = SubjectFactory.createSubject("CNET12", "Communication Networks", 36, "WH1");
    private Subject subject3 = SubjectFactory.createSubject("INM12", "Information Management", 36, "TA32");

    private Subject subjectCreated;

    @BeforeEach
    void test() {
        System.out.println("--TEST--");
    }

    void createSubject(Subject subject) {
        subjectCreated = subjectRepo.create(subject);
    }

    @Order(1)
    @Test
    void a_create() {
        createSubject(subject3);
        assertEquals(subjectCreated.getSubjectID(), subject3.getSubjectID());
        System.out.println("Subject Created: " + subjectCreated);

    }

    @Order(2)
    @Test
    void b_read() {
        createSubject(subject2);
        Subject subjectRead = subjectRepo.read(subjectCreated.getSubjectID());
        System.out.println("Subject Details: " + subjectRead);
    }

    @Order(3)
    @Test
    void c_update() {
        createSubject(subject);

        Subject subjectUpdated = new Subject.Builder().copy(subject).setSubjectID("CNF21").setSubjectName("Communication Fundamentals").build();
        subjectUpdated = subjectRepo.update(subjectUpdated);
        System.out.println("OLD: {ID: " + subject.getSubjectID() + "Name: " + subject.getSubjectName() + "\nNEW: {ID: " + subjectUpdated.getSubjectID() + ",Name: " + subjectUpdated.getSubjectName() + "}");

    }


    @Order(4)
    @Test
    void d_delete() {
        createSubject(subject);
        subjectRepo.delete(subject.getSubjectID());
        System.out.println("Deleted: " + subject.getSubjectID());
        System.out.println(subjectRepo.read(subject.getSubjectID()));

    }

    @Order(5)
    @Test
    void d_getAll() {
        System.out.println("Subjects: " + subjectRepo.getAll() + "\n");
    }


}
