package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Subject;

import java.util.Set;

/*
Generic Interface for SubjectRepositroy class
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
public interface ISubjectRepository extends JpaRepository<Subject,Integer> {


}
