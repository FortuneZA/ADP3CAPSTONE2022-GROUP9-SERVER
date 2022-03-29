package za.ac.cput.Factory;

import za.ac.cput.Entity.Lecturer;
import za.ac.cput.Util.GenericHelper;

public class LecturerFactory {
    public static Lecturer createLecturer(String firstName, String lastName, String lecturerEmail)
    {
        boolean validEmail= GenericHelper.emailValidation(lecturerEmail);
        String lecturerID = GenericHelper.generateID();

        if(firstName.isEmpty()              // check if first name is empty
                ||lastName.isEmpty()        // if last name is empty
                ||lecturerEmail.isEmpty()   // if email is empty
                ||!validEmail)              // if email is valid
            return null;
        return new Lecturer.Builder()
                .setLecturerID(lecturerID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setLecturerEmail(lecturerEmail)
                .build();
    }
}
