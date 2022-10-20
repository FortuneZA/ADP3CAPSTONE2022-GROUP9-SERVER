package za.ac.cput.service.impl;

import za.ac.cput.entity.Subject;
import za.ac.cput.service.IService;

import java.util.Set;

/*
Interface for Subject Service class
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */
public interface ISubjectService extends IService <Subject,Long> {

    Set<Subject> getAll();
}
