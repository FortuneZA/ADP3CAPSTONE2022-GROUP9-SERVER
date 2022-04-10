package za.ac.cput.Factory;

/* UniversityFactory.java
Factory for the University
Author: Cameron Henry Noemdo (219115443)
Date: 29 March 2022
*/

import za.ac.cput.Entity.University;
import za.ac.cput.Util.GenericHelper;

public class UniversityFactory {
    public static University createUniversity(String universityName, String city, String address, String phoneNumber)
    {
        String universityID = GenericHelper.generateID();
        if(universityName.isEmpty()
                ||city.isEmpty()
                ||address.isEmpty()
                ||phoneNumber.isEmpty()
                || !(phoneNumber.replaceAll("\\s+","").length() >=10 && phoneNumber.replaceAll("\\s+","").length() <=12)) // before checking length, whitespaces are replaced with no space
            {
            return null;
        }
        else {
            return new University.Builder()
                    .setUniversityID(universityID)
                    .setUniversityName(universityName)
                    .setCity(city)
                    .setAddress(address)
                    .setPhoneNumber(phoneNumber)
                    .build();
        }
    }
}
