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
import za.ac.cput.service.impl.ISystemAdminService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SystemAdminService implements ISystemAdminService {



    @Autowired
    private ISystemAdminRepository isystemAdminRepository;

    private static SystemAdminService service = null;

    public static SystemAdminService getService()
    {
        if(service == null)
        {
            service = new SystemAdminService();
        }

        return service;
    }


    @Override
    public Set<SystemAdmin> getAll() {
        return this.isystemAdminRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public SystemAdmin create(SystemAdmin systemAdmin) {
        return this.isystemAdminRepository.save(systemAdmin);
    }

    @Override
    public SystemAdmin read(String adminId) {

        return this.isystemAdminRepository.findById(adminId).orElseGet(null);
    }

    @Override
    public SystemAdmin update(SystemAdmin systemAdmin) {

        if(this.isystemAdminRepository.existsById(systemAdmin.getAdminId())){
            return this.isystemAdminRepository.save(systemAdmin);}
        return null;

    }

    @Override
    public boolean delete(String id) {
        this.isystemAdminRepository.deleteById(id);
        if(this.isystemAdminRepository.existsById(id))
            return false;
        else
            return true;
    }


}
