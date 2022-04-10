/*
 * DepartmentFactory.java
 * Factory for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */
package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {
    private  Department department;
    private  Department department1;
    private  Department department2;

    @Test
    public  void testObjectCreation(){
        Department department = DepartmentFactory.createDepartment("Finance department","fao@cput.ac.za");
        System.out.println(department.toString());
        assertNotNull(department);
    }

    @BeforeEach
    void setUp(){
        department = DepartmentFactory.createDepartment("Finance department", "fao@cput.ac.za");
        department1 = DepartmentFactory.createDepartment("IT department", "info@cput.ac.za");
        department2 = department;
    }

    @Test
    void testIdentity(){
        assertSame(department2,department);
    }

    @Test
    void testEquality(){
        assertEquals(department2,department);
    }

    @Test
    void testTimeOut(){
        assertTimeout(Duration.ofMillis(5000), ()->{
            Thread.sleep(1000);
        });
    }

    @Disabled
    @Test
    void disabledTest(){
        assertEquals(department,department1);
    }

}