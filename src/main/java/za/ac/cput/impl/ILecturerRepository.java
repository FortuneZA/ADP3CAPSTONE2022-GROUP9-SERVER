package za.ac.cput.impl;

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ILecturerRepository extends IRepository<Lecturer, String> {
    Set<Lecturer> getAll();
}
