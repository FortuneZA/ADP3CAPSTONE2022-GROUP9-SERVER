package za.ac.cput.repository.impl;

import za.ac.cput.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;
/*
Author: Themba Kanyile 217238173
Date : 17 October 2022
 */
@Repository
public interface ITestRepository extends JpaRepository<Test,String>{
    
}
