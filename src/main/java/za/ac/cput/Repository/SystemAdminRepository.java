package za.ac.cput.Repository;
/*
        SystemAdminRepository.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */
import za.ac.cput.Entity.SystemAdmin;
import za.ac.cput.impl.ISystemAdminRepository;
import java.util.HashSet;
import java.util.Set;

public class SystemAdminRepository implements ISystemAdminRepository {

    private static SystemAdminRepository repository = null;
    private Set<SystemAdmin> systemAdminDB= null;

    private SystemAdminRepository() {
        systemAdminDB = new HashSet<SystemAdmin>();
    }

    public static SystemAdminRepository getRepository(){
        if(repository == null)
            repository = new SystemAdminRepository();
        return repository;
    }

    @Override
    public SystemAdmin create(SystemAdmin systemAdmin) {
        boolean success = this.systemAdminDB.add(systemAdmin);
        if(!success)

            return null;
        return systemAdmin;
    }

    @Override
    public SystemAdmin read(String AdminId) {
        for(SystemAdmin systemAdmin: this.systemAdminDB){

            if(systemAdmin.getAdminID().equalsIgnoreCase(AdminId))
                return systemAdmin;
        }

        return null;
    }

    @Override
    public SystemAdmin update(SystemAdmin systemAdmin) {
        SystemAdmin updateSystem = read(systemAdmin.getAdminID());

        if (updateSystem != null) {
            this.systemAdminDB.remove(updateSystem);
            this.systemAdminDB.add(systemAdmin);
            return systemAdmin;
        }


        return null;
    }

    @Override
    public boolean delete(String AdminId) {
        SystemAdmin infoDelete = read(AdminId);

        if(infoDelete != null){

            this.systemAdminDB.remove(infoDelete);
            return true;
        }

        return false;
    }

    @Override
    public Set<SystemAdmin> getAll() {
        return systemAdminDB;
    }
}
