package za.ac.cput.impl;
/*
        ITutorRepository.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */
import za.ac.cput.Entity.Tutor;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ITutorRepository extends IRepository<Tutor,String> {

    public Set<Tutor> getAll();

}