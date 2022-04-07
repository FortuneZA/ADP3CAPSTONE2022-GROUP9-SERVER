package za.ac.cput.Repository;
/*
Student.java
Repository for Test
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */

import za.ac.cput.Entity.Test;

import java.util.HashSet;
import java.util.Set;

public class TestRepository implements ITestRepository
{
    private static TestRepository repository = null;
    private Set<Test> testDB= null;

    private TestRepository() {
        testDB = new HashSet<Test>();
    }

    public static TestRepository getRepository(){
        if(repository == null)
            repository = new TestRepository();
        return repository;
    }

    @Override
    public Test create(Test test) {
        boolean success = this.testDB.add(test);
        if(!success)
            return null;

        return test;
    }

    @Override
    public Test read(String TestId) {

        for (Test test : this.testDB) {
            String testId;
            if (test.getTestId().equalsIgnoreCase(TestId))
                return test;
        }

        return null;
    }

    @Override
    public Test update(Test test) {
        Test preUpdate = read(test.getTestId());

        if (preUpdate != null) {
            this.testDB.remove(preUpdate);
            this.testDB.add(test);
            return test;
        }

        return null;
    }

    @Override
    public boolean delete(String testId) {
        Test testToDelete = read(testId);

        if (testToDelete != null) {
            this.testDB.remove(testToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Test> getAll() {
        return testDB;
    }
}
