package za.ac.cput.service;
/*      EnrollmentService.java

        Author: Devon Daniels (217299822)

 */


import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Enrollment;
import za.ac.cput.Repository.EnrollmentRepository;
import za.ac.cput.service.impl.IEnrollmentService;

import java.util.Set;

@Service
public class EnrollmentService implements IEnrollmentService {
    private static EnrollmentService enrollmentService;
    private EnrollmentRepository enrollmentRepository;

    private EnrollmentService() {
        this.enrollmentRepository = EnrollmentRepository.getRepository();
    }

    public static EnrollmentService getEnrollmentService() {
        if (enrollmentService == null) {
            enrollmentService = new EnrollmentService();
        }
        return enrollmentService;
    }




    public Enrollment create(Enrollment enrollment) {

        return this.enrollmentRepository.create(enrollment);
    }


    public Enrollment read(String enrollmentName) {
        return this.enrollmentRepository.read(enrollmentName);

    }

    public Enrollment update(Enrollment enrollment)
    {return this.enrollmentRepository.update(enrollment);
    }

    public boolean delete(String enrollment) {
        return this.enrollmentRepository.delete(enrollment);

    }

    public Set<Enrollment> getAll() {
        return this.enrollmentRepository.getAll();

    }


}
