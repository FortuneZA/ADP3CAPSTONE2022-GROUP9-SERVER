package za.ac.cput.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.TestModel;
/*
Author: Themba Kanyile 217238173
Date : 17 October 2022
 */
@Repository
public interface ITestModelRepository extends JpaRepository<TestModel,String> {

}
