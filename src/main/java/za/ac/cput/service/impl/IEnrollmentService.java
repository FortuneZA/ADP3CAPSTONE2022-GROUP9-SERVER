package za.ac.cput.service.impl;
/*
    IEnrollmentService.java
    Author: Devon Daniels (217299822)

 */
import za.ac.cput.Entity.Enrollment;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IEnrollmentService extends IService<Enrollment,String> {
    Set<Enrollment> getAll();
}