package za.ac.cput.Factory;

/* UniversityFactory.java
Factory for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.Entity.University;
import za.ac.cput.Util.GenericHelper;

public class UniversityFactory {
    public static University createUniversity(String universityName, String city, String address, String phoneNumber)
    {
        String universityID = GenericHelper.generateID();
        if(!StringUtils.hasLength(universityName))
            throw new IllegalArgumentException("University name is not present");
        if(!StringUtils.hasLength(city))
            throw new IllegalArgumentException("City is not present");
        if(!StringUtils.hasLength(address))
            throw new IllegalArgumentException("Address is not present");
        if(!StringUtils.hasLength(phoneNumber))
            throw new IllegalArgumentException("Phone number is not present");
        if(!(phoneNumber.replaceAll("\\s+","").length() == 10 || phoneNumber.replaceAll("\\s+","").length() == 12))
            throw new IllegalArgumentException("Invalid phone number length provided");
        return new University.Builder()
                .setUniversityID(universityID)
                .setUniversityName(universityName)
                .setCity(city)
                .setAddress(address)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
