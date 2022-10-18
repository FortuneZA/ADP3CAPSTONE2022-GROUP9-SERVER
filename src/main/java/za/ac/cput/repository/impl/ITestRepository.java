package za.ac.cput.repository.impl;

import za.ac.cput.entity.Test;

import java.util.Collection;
import java.util.Optional;

public interface ITestRepository {
    Test save(Test test);

    Optional<Object> findById(String testId);

    boolean existsById(String testId);

    void deleteById(String id);

    Collection<Object> findAll();
}
