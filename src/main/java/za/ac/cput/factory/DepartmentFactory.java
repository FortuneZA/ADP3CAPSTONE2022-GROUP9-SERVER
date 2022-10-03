/*
 * DepartmentFactory.java
 * Factory for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.factory;

import za.ac.cput.entity.Department;
import za.ac.cput.util.GenericHelper;

import java.util.List;

public class DepartmentFactory {

    public static Department createDepartment(String departmentName, String departmentEmail,String departmentTelephone , List<String> courseList){
        String departmentID = GenericHelper.generateID();

        if(!GenericHelper.emailValidation(departmentEmail))
            return null;

        if(departmentID== null || departmentID.isEmpty())
            throw new IllegalArgumentException("Please provide department Id");
        if(departmentName == null || departmentName.isEmpty())
            throw new IllegalArgumentException("Please provide department name");
        if(departmentEmail == null || departmentEmail.isEmpty())
            throw new IllegalArgumentException("Please provide department email address");
        if(departmentTelephone == null || departmentTelephone.isEmpty())
            throw new IllegalArgumentException("Please provide department telephone number");


        Department department = new Department.Builder()
                .setDepartmentID(departmentID)
                .setDepartmentName(departmentName)
                .setDepartmentEmail(departmentEmail)
                .setDepartmentTelephone(departmentTelephone)
                .setCourseList(courseList)
                .build();
        return department;
    }
}
