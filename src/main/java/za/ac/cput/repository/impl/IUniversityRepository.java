package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.University;

import java.util.Set;

/*
    IUniversityRepository.java
    Repository interface for the University
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */
public interface IUniversityRepository extends JpaRepository<University,String> {
    Set<University> getAll();
}
