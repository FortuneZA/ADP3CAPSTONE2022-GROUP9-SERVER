package za.ac.cput.factory;

/* UniversityFactory.java
Factory for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.entity.University;
import za.ac.cput.util.GenericHelper;

public class UniversityFactory {
    public static University createUniversity(String universityName, String email)
    {
        String universityId=GenericHelper.generateID();

        if(!StringUtils.hasLength(universityName))
            throw new IllegalArgumentException("University name is not present");
        if(!StringUtils.hasLength(email))
            throw new IllegalArgumentException("Email is not present");
        GenericHelper.emailValidation(email);
//        if(facultyList.isEmpty())
//            throw new IllegalArgumentException("No faculties are present");
        return new University.Builder()
                .setUniversityId(universityId)
                .setUniversityName(universityName)
                .setEmail(email)
                //.setFacultyList(facultyList)
                .build();
    }
}
