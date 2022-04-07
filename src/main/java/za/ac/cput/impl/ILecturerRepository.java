package za.ac.cput.impl;

/* ILecturerRepository.java
Implementation of Repository for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ILecturerRepository extends IRepository<Lecturer, String> {
    Set<Lecturer> getAll();
}
