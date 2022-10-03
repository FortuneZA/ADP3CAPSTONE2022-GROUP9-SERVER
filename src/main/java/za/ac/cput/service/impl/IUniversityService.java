package za.ac.cput.service.impl;

import za.ac.cput.entity.University;
import za.ac.cput.service.IService;

/*
    IUniversityService.java
    Service interface for the University
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */

import java.util.Set;

public interface IUniversityService extends IService<University,String> {
    Set<University> getAll();
}
