package za.ac.cput.factory;
/*
        SystemAdminFactory.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
 */
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.util.GenericHelper;

public class SystemAdminFactory {

    public static SystemAdmin createSystemAdmin( String adminName, String email) {
        String adminId = GenericHelper.generateID();

        return new SystemAdmin.Builder()
                .setAdminId(adminId)
                .setAdminName(adminName)
                .setAdminEmail(email)
                .build();


    }
}
