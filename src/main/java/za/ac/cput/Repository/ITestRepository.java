package za.ac.cput.Repository;

import za.ac.cput.Entity.Test;

import java.util.Set;
public interface ITestRepository extends IRepository <Test, String>{
public Set<Test> getAll();
        }


