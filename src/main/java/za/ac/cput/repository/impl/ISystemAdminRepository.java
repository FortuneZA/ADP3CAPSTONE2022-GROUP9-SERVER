package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.SystemAdmin;
import org.springframework.stereotype.Repository;
@Repository
public interface ISystemAdminRepository extends JpaRepository<SystemAdmin,String> {
}
