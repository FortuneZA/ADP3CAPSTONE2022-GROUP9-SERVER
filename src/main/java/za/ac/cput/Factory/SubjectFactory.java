package za.ac.cput.Factory;

/* SubjectFactory.java
 Factory Class for the Subject entity
 Author: Mathew Fortuin -219069514
 Date: 15/03/2022
*/

import za.ac.cput.Entity.Subject;
import za.ac.cput.Util.GenericHelper;

public class SubjectFactory {

    public static Subject createSubject(String subjectID, String subjectName,int subjectCredit, String lecturerID)
    {
        String subjectHelper = GenericHelper.generateID();

        Subject subject = new Subject.Builder()
                .setSubjectID("ADP372S")
                .setSubjectName("Application Development Practice 3")
                .setSubjectCredit(36)
                .setLecturerID("KB034")
                .build();

        return subject;

    }
}
