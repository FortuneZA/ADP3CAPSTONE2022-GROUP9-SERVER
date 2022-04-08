package za.ac.cput.impl;
/*
        IMarkRepository.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

import za.ac.cput.Entity.Mark;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IMarkRepository extends IRepository<Mark, String> {

    public Set<Mark> getAll();
}
