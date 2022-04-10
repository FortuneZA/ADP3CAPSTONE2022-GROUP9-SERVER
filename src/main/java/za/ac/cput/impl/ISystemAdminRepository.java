package za.ac.cput.impl;
/*
        ISystemAdminRepository.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */

import za.ac.cput.Entity.SystemAdmin;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface ISystemAdminRepository  extends IRepository<SystemAdmin, String> {
    public Set<SystemAdmin> getAll();

}

