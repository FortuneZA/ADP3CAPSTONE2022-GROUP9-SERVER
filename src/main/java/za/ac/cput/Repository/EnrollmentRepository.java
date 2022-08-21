package za.ac.cput.Repository;
/*
        EnrollmentRepository.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import za.ac.cput.Entity.Enrollment;
import za.ac.cput.impl.IEnrollmentRepository;

import java.util.HashSet;
import java.util.Set;

public class EnrollmentRepository implements IEnrollmentRepository {

    private static EnrollmentRepository repository = null;
    private Set<Enrollment> enrollmentDB= null;

    private EnrollmentRepository() {
        enrollmentDB = new HashSet<Enrollment>();
    }

    public static EnrollmentRepository getRepository(){
        if(repository == null)
            repository = new EnrollmentRepository();
        return repository;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        boolean success = this.enrollmentDB.add(enrollment);
        if(!success)

            return null;
        return enrollment;
    }

    @Override
    public Enrollment read(String EnrollmentID) {
        for(Enrollment enrollment: this.enrollmentDB){

            if(enrollment.getEnrollmentID().equalsIgnoreCase(EnrollmentID))
                return enrollment;
        }

        return null;
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        Enrollment updateSystem = read(enrollment.getEnrollmentID());

        if (updateSystem != null) {
            this.enrollmentDB.remove(updateSystem);
            this.enrollmentDB.add(enrollment);
            return enrollment;
        }


        return null;
    }

    @Override
    public boolean delete(String EnrollmentID) {
        Enrollment infoDelete = read(EnrollmentID);

        if(infoDelete != null){

            this.enrollmentDB.remove(infoDelete);
            return true;
        }

        return false;
    }

    @Override
    public Set<Enrollment> getAll() {
        return enrollmentDB;
    }
}