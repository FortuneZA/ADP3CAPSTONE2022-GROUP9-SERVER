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
import za.ac.cput.service.impl.SystemAdminService;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SystemAdminServiceTest {

    private  static SystemAdminService SystemAdminService;
    public static SystemAdmin systemAdmin = new SystemAdminFactory().createSystemAdmin("Lefu", "Kumeke@gmail.com");



    @Test
    public void a_create()
    {
        SystemAdmin created = SystemAdminService.create(systemAdmin);
        assertEquals(created.getAdminEmail(),systemAdmin.getAdminEmail());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        SystemAdmin read = SystemAdminService.read(systemAdmin.getAdminID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {
        SystemAdmin updated = new SystemAdmin.Builder().copy(systemAdmin).setAdminName("John").setAdminEmail("johh@gmail.com").build();
        assertNotNull(SystemAdminService.update(updated));
        System.out.println("Updated: " + updated);

    }

    @Test
    void e_delete() {

        boolean deleted = SystemAdminService.delete(systemAdmin.getAdminID());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);

    }
    @Test
    void d_getAll() {
        System.out.println(SystemAdminService.getAll() + "\n");
    }
}