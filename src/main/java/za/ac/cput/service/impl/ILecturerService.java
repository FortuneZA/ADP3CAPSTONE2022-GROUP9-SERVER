package za.ac.cput.service.impl;

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.service.IService;

/*
    ILecturerService.java
    Service interface for the Lecturer
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */

import java.util.Set;

public interface ILecturerService extends IService<Lecturer,String> {
    Set<Lecturer> getAll();
}
