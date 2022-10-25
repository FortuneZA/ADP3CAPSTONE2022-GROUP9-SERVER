package za.ac.cput.factory;
/*import za.ac.cput.entity.Student;
import za.ac.cput.util.GenericHelper;
Factory for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022*/


import za.ac.cput.entity.Student;
import za.ac.cput.util.GenericHelper;

public class StudentFactory
{
    public static Student createStudent(String firstName, String middleName, String lastName, String studentEmail, String courseID){
       if(!GenericHelper.emailValidation(studentEmail))
           return null;

        String studentID = GenericHelper.generateID();
        Student student = new Student.Builder()
                .setStudentId(studentID)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setStudentEmail(studentEmail)
                .setCourseID(courseID)
                .build();

        return student;
    }
}
