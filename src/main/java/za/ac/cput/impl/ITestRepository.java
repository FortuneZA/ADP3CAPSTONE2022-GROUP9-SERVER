package za.ac.cput.impl;

import za.ac.cput.Entity.Test;
import za.ac.cput.Repository.IRepository;

import java.util.Set;
public interface ITestRepository extends IRepository<Test, String> {
public Set<Test> getAll();
        }


