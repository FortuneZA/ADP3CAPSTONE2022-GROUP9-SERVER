package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Department;
import za.ac.cput.repository.impl.IDepartmentRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*DepartmentService.java
Department service entity
Author: Mawande Langa (219074054)
Date : 07/10/2022

 */
@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;
    private static DepartmentService departmentService = null;

    public static DepartmentService getDepartmentService(){
        if(departmentService == null){
            departmentService = new DepartmentService();
        }
        return  departmentService;
    }

    @Override
    public Department create(Department department) {
        return this.departmentRepository.save(department);
    }

    @Override
    public Department read(String departmentID) {
        return this.departmentRepository.findById(departmentID).orElse(null);
    }

    @Override
    public Department update(Department department) {
        if(this.departmentRepository.existsById(department.getDepartmentID())){
            return this.departmentRepository.save(department);

        }
        return null;
    }

    @Override
    public boolean delete(String departmentID) {
        this.departmentRepository.deleteById(departmentID);
        if(this.departmentRepository.existsById(departmentID)){
            return false;
        }

        return true;
    }

    @Override
    public Set<Department> getAll() {
        return this.departmentRepository.findAll().stream().collect(Collectors.toSet());
    }
}
