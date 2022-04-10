/*
 * FacultyFactory.java
 * Factory for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 30 March 2022
 * */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Faculty;
import za.ac.cput.Util.GenericHelper;

public class FacultyFactory {

    public static Faculty createFaculty(String facultyName,String facultyEmail){
        String facultyID = GenericHelper.generateID();

        if(!GenericHelper.emailValidation(facultyEmail))
            return null;

        if(facultyName.isEmpty() || facultyEmail.isEmpty())
            return null;

        Faculty faculty = new Faculty.Builder()
                .setFacultyID(facultyID)
                .setFacultyName(facultyName)
                .setFacultyEmail(facultyEmail)
                .build();
        return faculty;
    }
}
