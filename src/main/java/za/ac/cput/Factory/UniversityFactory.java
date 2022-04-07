package za.ac.cput.Factory;

import za.ac.cput.Entity.University;
import za.ac.cput.Util.GenericHelper;

public class UniversityFactory {
    public static University createUniversity(String universityName, String city, String address, String phoneNumber)
    {
        String universityID = GenericHelper.generateID();
        if(universityName.isEmpty()
                ||city.isEmpty()
                ||address.isEmpty()
                ||phoneNumber.isEmpty())
//                ||(!phoneNumber.trim().substring(0,1).contains("0")&&!phoneNumber.trim().substring(0,3).contains("+27"))
//                ||!phoneNumber.matches("^(?:[\\s]?[0-9+]){10,12}$")) // replace phone number validation with an actual validator
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
