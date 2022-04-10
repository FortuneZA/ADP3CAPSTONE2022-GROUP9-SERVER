/*
 * DepartmentRepository.java
 * Repository for the Department
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Repository;
import za.ac.cput.Entity.Department;
import za.ac.cput.impl.IDepartmentRepository;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository implements IDepartmentRepository {
    private static DepartmentRepository repository = null;
    private Set<Department> departmentDB = null;

    private DepartmentRepository(){
        departmentDB = new HashSet<Department>();
    }

    public static DepartmentRepository getRepository(){
        if(repository == null)
            repository = new DepartmentRepository();
        return repository;
    }

    @Override
    public Department create(Department department) {
        boolean success = departmentDB.add(department);
        if(!success)
        return null;

        return department;
    }

    @Override
    public Department read(String departmentID) {
        for(Department department : this.departmentDB){
            if(department.getDepartmentID().equals(departmentID));
            return department;
        }
        return null;
    }

    @Override
    public Department update(Department department) {
        Department oldDepartment = read(department.getDepartmentID());
        if(oldDepartment != null) {
            this.departmentDB.remove(oldDepartment);
            this.departmentDB.add(department);
        }
        return department;
    }

    @Override
    public boolean delete(String departmentID) {
        Department departmentToDelete = read(departmentID);
        if(departmentToDelete != null)
            this.departmentDB.remove(departmentToDelete);
            return true;
    }

    @Override
    public Set<Department> getAll() {
        return this.departmentDB;
    }
}
