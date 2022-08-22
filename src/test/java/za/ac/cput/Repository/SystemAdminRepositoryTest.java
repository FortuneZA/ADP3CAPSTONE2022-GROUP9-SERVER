package za.ac.cput.Repository;
/*
      SystemAdminRepository.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.SystemAdmin;
import za.ac.cput.Factory.SystemAdminFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class SystemAdminRepositoryTest {

    private static SystemAdminRepository systemAdminRepository = SystemAdminRepository.getRepository();
    private static SystemAdmin systemAdmin = SystemAdminFactory.createSystemAdmin("Paul", "Paul@gmail.com");


    @Test
    void a_create() {

        SystemAdmin created =         systemAdminRepository.create(systemAdmin);
        assertEquals(created.getAdminID(), systemAdmin.getAdminID());
        System.out.println("Created ID: " + created.getAdminID()+ "\nAdmin ID: " + systemAdmin.getAdminID() + "\n");
    }

    @Test
    void b_read() {

        SystemAdmin read = systemAdminRepository.read(systemAdmin.getAdminID());
        assertNotNull(read);
        System.out.println("Read: " + read + "\n");
    }

    @Test
    void c_update() {

        SystemAdmin updated = new SystemAdmin.Builder().copy(systemAdmin).setAdminName("John").setAdminEmail("John1@gmail.com").build();
        assertNotNull(systemAdminRepository.update(updated));
        System.out.println("Updated (" + updated.getAdminID() + "): " + updated.getAdminName() + " " + updated.getAdminEmail());
    }

    @Test
    void e_delete() {

        boolean deleted = systemAdminRepository.delete(systemAdmin.getAdminID());
        //assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {

        System.out.println("\nDisplay all :" );
        System.out.println(systemAdminRepository.getAll() + "\n");
    }
}
