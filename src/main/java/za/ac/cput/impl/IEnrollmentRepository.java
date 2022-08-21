package za.ac.cput.impl;
/*
        IEnrollmentRepository.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import za.ac.cput.Entity.Enrollment;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IEnrollmentRepository extends IRepository<Enrollment,String> {

    public Set<Enrollment> getAll();

}