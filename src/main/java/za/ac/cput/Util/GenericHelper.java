package za.ac.cput.Util;
import java.util.UUID;
public class GenericHelper
{
    //student
    public static String generateID(){
        return UUID.randomUUID().toString();

    }
}
