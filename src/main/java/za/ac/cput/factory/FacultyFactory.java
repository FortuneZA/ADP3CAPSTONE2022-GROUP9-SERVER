/*
 * FacultyFactory.java
 * Factory for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.factory;

import za.ac.cput.entity.Faculty;
import za.ac.cput.util.GenericHelper;

import java.util.List;

public class FacultyFactory {

    public static Faculty createFaculty(String facultyName, List<String> departmentList){
        String facultyID = GenericHelper.generateID();

        if(facultyID == null || facultyID.isEmpty())
            throw new IllegalArgumentException("Please provide faculty Id");
        if(facultyName == null || facultyName.isEmpty())
            throw new IllegalArgumentException("Please provide faculty name ");

        Faculty faculty = new Faculty.Builder()
                .setFacultyID(facultyID)
                .setFacultyName(facultyName)
                .setDepartmentList(departmentList)
                .build();
        return faculty;
    }
}
