package za.ac.cput.repository.impl;

import za.ac.cput.entity.Student;

import java.util.Collection;
import java.util.Optional;
/*
Author: Themba Kanyile 217238173
Date : 17 October 2022
 */
public interface IStudentRepository {
    Student save(Student student);

    Optional<Object> findById(String studentId);

    boolean existsById(String studentId);

    void deleteById(String id);

    Collection<Object> findAll();
}
