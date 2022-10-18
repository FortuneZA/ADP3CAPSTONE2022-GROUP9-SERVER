package za.ac.cput.service.impl;

import za.ac.cput.entity.Student;

import java.util.Set;

/*
Interface for Student Service class
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
public interface IStudentService {
    Student create(Student student);

    Object read(String studentId);

    Student update(Student student);

    boolean delete(String id);

    Set<Object> getAll();
}
