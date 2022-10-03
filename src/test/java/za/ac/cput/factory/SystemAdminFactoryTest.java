package za.ac.cput.factory;
/*
        SystemAdminFactoryTest.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.SystemAdmin;
import static org.junit.jupiter.api.Assertions.*;

class SystemAdminFactoryTest {

    //object creation
    @Test
    public void test()
    {
        SystemAdmin systemAdmin =  SystemAdminFactory.createSystemAdmin("Thato", "Thato@gmail.com ");

        assertNotNull(systemAdmin.toString());
        System.out.println(systemAdmin);
    }
}