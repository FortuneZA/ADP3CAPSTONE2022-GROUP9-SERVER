package za.ac.cput.service.impl;
/*
 SystemAdminService.java
 Author: Lefu Kumeke 218147856
 Date :08 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.repository.impl.ISystemAdminRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class SystemAdminService implements ISystemAdminService {

    private static SystemAdminService service= null;

    @Autowired
    private ISystemAdminRepository repository;

    public static SystemAdminService getService()
    {
        if (service == null)
        {
            service = new SystemAdminService();
        }
        return service;
    }

    @Override
    public SystemAdmin create(SystemAdmin systemAdmin) {
        return this.repository.save(systemAdmin);
    }

    @Override
    public SystemAdmin read(String adminID) {
        return this.repository.findById(adminID).orElse(null);
    }

    @Override
    public SystemAdmin update(SystemAdmin systemAdmin) {

        if(this.repository.existsById(systemAdmin.getAdminID()))
            return this.repository.save(systemAdmin);
        return null;

    }

    @Override
    public boolean delete(String adminID) {
        this.repository.deleteById(adminID);
        if(this.repository.existsById(adminID))
            return false;
        else
            return true;
    }

    @Override
    public Set<SystemAdmin> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
