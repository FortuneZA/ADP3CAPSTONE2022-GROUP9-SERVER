package za.ac.cput.impl;

/* IUniversityRepository.java
Implementation of Repository for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import za.ac.cput.Entity.University;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IUniversityRepository extends IRepository<University, String> {
    Set<University> getAll();
}