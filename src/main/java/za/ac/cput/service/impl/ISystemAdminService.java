package za.ac.cput.service.impl;

import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.service.IService;

import java.util.Set;

/*

 */
public interface ISystemAdminService extends IService<SystemAdmin,String> {

    Set<SystemAdmin> getAll();
}
