package za.ac.cput.impl;

/* ISubjectRepository.java
 Interface for the Subject entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/

import za.ac.cput.Entity.Subject;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ISubjectRepository extends IRepository<Subject,String> {

    public Set<Subject> getAll();
}
