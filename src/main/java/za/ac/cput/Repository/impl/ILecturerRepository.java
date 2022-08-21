package za.ac.cput.Repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Lecturer;

import java.util.Set;

/*

 */
public interface ILecturerRepository extends JpaRepository<Lecturer, String> {
    Set<Lecturer> getAll();
}