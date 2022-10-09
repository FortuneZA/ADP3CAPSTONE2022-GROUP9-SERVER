package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Lecturer;

/*
    ILecturerRepository.java
    Repository for the Lecturer
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */

@Repository
public interface ILecturerRepository extends JpaRepository<Lecturer, String> {

}