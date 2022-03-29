package za.ac.cput.Util;


import org.apache.commons.validator.routines.EmailValidator;

// =======

import java.util.UUID;

public class GenericHelper {


    // ID generator
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    // email validator
    public static boolean emailValidation(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
// =======
    /*
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
     */

}
