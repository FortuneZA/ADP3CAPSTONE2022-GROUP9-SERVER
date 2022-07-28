package za.ac.cput.Factory;

/* LecturerFactory.java
Factory for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Util.GenericHelper;

public class LecturerFactory {
    public static Lecturer createLecturer(String firstName, String lastName, String lecturerEmail)
    {
        String lecturerID = GenericHelper.generateID();

        if(!StringUtils.hasLength(firstName))
            throw new IllegalArgumentException("First name is not present");
        if(!StringUtils.hasLength(lastName))
            throw new IllegalArgumentException("Last name is not present");
        if(!StringUtils.hasLength(lecturerEmail))
            throw new IllegalArgumentException("Email is not present");
        GenericHelper.emailValidation(lecturerEmail);
        return new Lecturer.Builder()
                .setLecturerID(lecturerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setLecturerEmail(lecturerEmail)
                .build();
    }
}
