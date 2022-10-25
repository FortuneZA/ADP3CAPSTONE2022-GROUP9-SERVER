/*
package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Department;

import java.util.Set;

*/
/*IDepartmentRepository.java
Repository for the Department
Author: Mawande Langa (219074054)
Date: 07/10/2022*//*




@Repository
public interface IDepartmentRepository extends JpaRepository<Department,String> {
    Set<Department> getAll();
}
*/
