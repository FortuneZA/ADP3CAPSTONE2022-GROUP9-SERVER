package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.University;

/*
    IUniversityRepository.java
    Repository interface for the University
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */

@Repository
public interface IUniversityRepository extends JpaRepository<University,String> {

}
