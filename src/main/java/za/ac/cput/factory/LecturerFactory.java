package za.ac.cput.factory;

/* LecturerFactory.java
Factory for the Lecturer
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.util.GenericHelper;

public class LecturerFactory {
    public static Lecturer createLecturer(String firstName, String middleName, String lastName, String lecturerEmail, String departmentId)
    {
        String lecturerID = GenericHelper.generateID();

        if(!StringUtils.hasLength(firstName)||firstName.equals(""))
            throw new IllegalArgumentException("First name is not present");
        if(!StringUtils.hasLength(lastName)||lastName.equals(""))
            throw new IllegalArgumentException("Last name is not present");
        if(!StringUtils.hasLength(lecturerEmail)||lecturerEmail.equals(""))
            throw new IllegalArgumentException("Email is not present");
        GenericHelper.emailValidation(lecturerEmail);
        if(!StringUtils.hasLength(departmentId)||departmentId.equals(""))
            throw new IllegalArgumentException("Department ID is not present");
        return new Lecturer.Builder()
                .setLecturerId(lecturerID)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setLecturerEmail(lecturerEmail)
                .setDepartmentId(departmentId)
                .build();
    }
}
