package za.ac.cput.impl;

import za.ac.cput.Entity.University;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IUniversityRepository extends IRepository<University, String> {
    Set<University> getAll();
}