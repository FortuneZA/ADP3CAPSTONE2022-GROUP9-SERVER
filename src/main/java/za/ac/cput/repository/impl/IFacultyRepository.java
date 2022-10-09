package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Faculty;

import java.util.Set;

/*IFacultyRepository.java
Repository for the Faculty
Author: Mawande Langa (219074054)
Date: 07/10/2022

 */
@Repository
public interface IFacultyRepository extends JpaRepository<Faculty,String> {
    Set<Faculty> getAll();
}
