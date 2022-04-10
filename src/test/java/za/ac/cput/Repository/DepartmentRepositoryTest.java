/*
 * DepartmentRepositoryTest.java
 * Test for the DepartmentRepository
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */
package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DepartmentRepositoryTest {

    private static DepartmentRepository departmentRepository = DepartmentRepository.getRepository();
    private static Department department = DepartmentFactory.createDepartment("Finance department", "info@cput.ac.za");

    @Test
    void a_create() {
        Department created = departmentRepository.create(department);
        assertEquals(department.getDepartmentID(), created.getDepartmentID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Department read = departmentRepository.read(department.getDepartmentID());
        assertNotNull(read);
        System.out.println("Read " + read);
    }

    @Test
    void c_update() {
        Department updated = new Department.Builder().copy(department).setDepartmentName("Financial Aid Office")
                                .setDepartmentEmail("fao@cput.ac.za")
                                .build();
        assertNotNull(departmentRepository.update(updated));
        System.out.println("Updated :" + updated);
    }

    @Test
    void e_delete() {
        boolean success = departmentRepository.delete(department.getDepartmentID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("All in the set");
        System.out.println(departmentRepository.getAll());
    }
}