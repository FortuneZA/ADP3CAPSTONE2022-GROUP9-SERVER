/*
 * DepartmentFactory.java
 * Factory for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */
package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    List<String> courseList = Arrays.asList("ICT in Application Development","Visual Communication Design","ICT in Communication Networks");
    private final  Department department = DepartmentFactory.createDepartment("Information Technology","infor@cput.ac.za","+27 21 959 6767", courseList);
    private  Department department1;
    @Order(1)
    @Test
    void buildDepartmentTestWithSuccess(){
        System.out.println(department);
        assertAll(
                ()->assertNotNull(department),
                ()->assertEquals("Information Technology",department.getDepartmentName())
        );
    }

    @Order(2)
    @Test
    void buildDepartmentWithEmptyName(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                department1 = DepartmentFactory.createDepartment("","infor@cput.ac.za","+27 21 959 6767", courseList));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide department name",exceptionMessage);

    }

    @Order(3)
    @Test
    void buildDepartmentWithNullEmail(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                department1 = DepartmentFactory.createDepartment("Information Technology","infor@cput.ac.za",null , courseList));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Please provide department telephone number", exceptionMessage);
    }


}