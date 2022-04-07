package za.ac.cput.Factory;
import za.ac.cput.Entity.Student;
import za.ac.cput.Util.GenericHelper;
/*
Factory for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */
public class StudentFactory
{
    public static Student createStudent(String firstName, String lastName, String studentEmail, String courseID){
       if(!GenericHelper.isValidEmail(studentEmail))
           return null;

        String studentID = GenericHelper.generateID();
        Student student = new Student.Builder()
                .setStudentId(studentID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStudentEmail(studentEmail)
                .setCourseID(courseID)
                .build();

        return student;
    }
}
