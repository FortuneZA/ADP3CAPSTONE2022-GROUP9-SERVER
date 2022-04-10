package za.ac.cput.impl;

import za.ac.cput.Entity.Department;
import za.ac.cput.Repository.IRepository;

import java.util.Set;

public interface IDepartmentRepository extends IRepository<Department, String> {
    public Set<Department> getAll();
}
