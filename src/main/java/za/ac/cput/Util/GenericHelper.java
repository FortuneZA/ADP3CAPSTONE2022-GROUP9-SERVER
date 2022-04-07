package za.ac.cput.Util;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;
public class GenericHelper
{

    //Student Email Validator
    public static boolean isValidEmail (String studentEmail)
    {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(studentEmail);
    }
    //student
    public static String generateID(){
        return UUID.randomUUID().toString();

    }
}
