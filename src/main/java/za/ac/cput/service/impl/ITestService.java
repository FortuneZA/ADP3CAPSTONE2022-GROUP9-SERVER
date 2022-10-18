package za.ac.cput.service.impl;

import za.ac.cput.entity.Test;

import java.util.Set;

/*

 */
public interface ITestService {
    Test create(Test test);

    Test read(String testId);

    Test update(Test test);

    boolean delete(String id);

    Set<Object> getAll();
}
