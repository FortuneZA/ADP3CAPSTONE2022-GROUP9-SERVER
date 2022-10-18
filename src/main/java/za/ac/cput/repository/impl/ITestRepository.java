package za.ac.cput.repository.impl;

import za.ac.cput.entity.Test;

import java.util.Collection;
import java.util.Optional;
/*
Author: Themba Kanyile 217238173
Date : 17 October 2022
 */
public interface ITestRepository {
    Test save(Test test);

    Optional<Object> findById(String testId);

    boolean existsById(String testId);

    void deleteById(String id);

    Collection<Object> findAll();
}
