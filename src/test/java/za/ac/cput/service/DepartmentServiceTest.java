package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.service.impl.DepartmentService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

/*DepartmentService.java test cases
Author: Mawande Langa (219074054)
Date: 09/10/2022

 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class DepartmentServiceTest {
private DepartmentService departmentService = DepartmentService.getDepartmentService();
 private static    List<String> courseList = Arrays.asList("ICT in Application Development","Visual Communication Design","ICT in Communication Networks");
private static Department createDepartment = DepartmentFactory.createDepartment("Informatics & Design","infor@cput.ac.za","0834259826",courseList);

@Test
    void a_create(){
    Department create = departmentService.create(createDepartment);
    assertEquals(create.getDepartmentID(),createDepartment.getDepartmentID());
    System.out.println("Created: "+ create.toString());
}

@Test
    void b_read(){
    Department read = departmentService.read(createDepartment.getDepartmentID());
    assertNotNull(read);
    System.out.println("Read: "+ read);
}

@Test
    void c_update(){
    Department update = new Department.Builder().copy(createDepartment).setDepartmentID("219074054").setDepartmentName("Computer Science").setDepartmentEmail("infor@cput.ac.za").setDepartmentTelephone("034259826").setCourseList(courseList).build();
    assertNotNull(update);
    System.out.println("Updated "+ update);
}

@Test
    void d_delete(){
    boolean delete = departmentService.delete(createDepartment.getDepartmentID());
    assertTrue(delete);
    System.out.println("Delete: "+ delete);
}

@Test
    void e_getAll(){
    System.out.println(departmentService.getAll());
}
}