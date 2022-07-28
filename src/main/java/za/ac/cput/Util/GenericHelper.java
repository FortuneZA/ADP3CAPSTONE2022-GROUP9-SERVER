package za.ac.cput.Util;
/*
Generic Helper.java
Automatic Generator for values
Author: Mathew Fortuin - 219069514
 */

import org.apache.commons.validator.routines.EmailValidator;



import java.util.UUID;

public class GenericHelper {


    // ID generator
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    // email validator
    public static boolean emailValidation(String email) {
        if(!EmailValidator.getInstance().isValid(email))
            throw new IllegalArgumentException("Invalid email");
        return EmailValidator.getInstance().isValid(email);
    }



}
