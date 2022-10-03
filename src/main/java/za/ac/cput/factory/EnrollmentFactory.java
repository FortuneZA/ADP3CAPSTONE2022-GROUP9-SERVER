package za.ac.cput.factory;
/*
        EnrollmentFactory.java
        Author: Devon Daniels 217299822
        Date :15 August 2022
        */

import za.ac.cput.entity.Enrollment;
import za.ac.cput.util.GenericHelper;

public class EnrollmentFactory {

    public static Enrollment createEnrollment(String enrollmentDetails, String enrollmentDates) {
        String enrollmentID = GenericHelper.generateID();

        Enrollment enrollment = new Enrollment.Builder()
                .setEnrollmentID(enrollmentID)
                .setEnrollmentDetails(enrollmentDetails)
                .setEnrollmentDates(enrollmentDates)

                .build();

        return enrollment;
    }
}