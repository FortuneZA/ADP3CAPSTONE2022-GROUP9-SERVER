package za.ac.cput.service;
/*
SystemAdminServiceTest.java
 Author: Lefu Kumeke 218147856
 Date :08 October 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;
import za.ac.cput.service.impl.ISystemAdminService;
import za.ac.cput.service.impl.SystemAdminService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SystemAdminServiceTest {


    @Autowired
     private SystemAdminService systemAdminService = new SystemAdminService() ;
     private static SystemAdmin admin = SystemAdminFactory.createSystemAdmin("Lefu", "Kumeke@gmail.com");

  

    @Test
    void d_getAll() {
        Set<SystemAdmin>  sAdmin=systemAdminService.getAll();
        System.out.println( sAdmin + "\n");
    }
    @Test
    public void a_create()
    {
        SystemAdmin createAdmin = systemAdminService.create(admin);
        assertEquals(createAdmin.getAdminEmail(),admin.getAdminEmail());
        System.out.println("Create:" + admin);
    }

    @Test
    void b_read() {

        SystemAdmin read = systemAdminService.read(admin.getAdminID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {

        SystemAdmin updated = new SystemAdmin.Builder().copy(admin).setAdminName("John").setAdminEmail("johh@gmail.com").build();
        assertNotNull(systemAdminService.update(updated));
        System.out.println("Updated: " + updated);

    }

    @Test
    void e_delete() {
        boolean deleted = systemAdminService.delete(admin.getAdminID());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);

    }

}