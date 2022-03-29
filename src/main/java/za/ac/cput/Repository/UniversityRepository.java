package za.ac.cput.Repository;

/* UniversityRepository.java
Repository for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import za.ac.cput.Entity.University;
import za.ac.cput.impl.IUniversityRepository;

import java.util.HashSet;
import java.util.Set;

public class UniversityRepository implements IUniversityRepository {

    private static UniversityRepository universityRepository=null;
    private Set<University> universityDB;

    public UniversityRepository()
    {
        universityDB=new HashSet<>();
    }

    public static UniversityRepository getRepository(){
        if(universityRepository==null)
            universityRepository=new UniversityRepository();
        return universityRepository;
    }

    @Override
    public University create(University university) {
        boolean success=universityDB.add(university);
        if(!success)
            return null;
        return university;
    }

    @Override
    public University read(String universityId) {
        for(University u: universityDB)
            if(u.getUniversityID().equals(universityId))
                return u;
        return null;
    }

    @Override
    public University update(University university) {
        University oldUniversity=read(university.getUniversityID());
        if(oldUniversity!=null) {
            this.universityDB.remove(oldUniversity);
            this.universityDB.add(university);
        }
        return university;
    }

    @Override
    public boolean delete(String universityId) {
        University university=read(universityId);
        if(universityId!=null) {
            this.universityDB.remove(university);
            return true;
        }
        return false;
    }

    @Override
    public Set<University> getAll() {
        return this.universityDB;
    }
}
