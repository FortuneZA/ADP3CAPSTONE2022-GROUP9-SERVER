/*
 * DepartmentFactory.java
 * Factory for the Department
 * Author: Mawande Langa (219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Department;
import za.ac.cput.Util.GenericHelper;

public class DepartmentFactory {

    public static Department createDepartment(String departmentName, String departmentEmail){
        String departmentID = GenericHelper.generateID();

        if(!GenericHelper.emailValidation(departmentEmail))
            return null;

        if(departmentName.isEmpty() || departmentEmail.isEmpty())
            return null;


        Department department = new Department.Builder()
                .setDepartmentID(departmentID)
                .setDepartmentName(departmentName)
                .setDepartmentEmail(departmentEmail)
                .build();
        return department;
    }
}
