package za.ac.cput.Factory;

/* SubjectFactory.java
 Factory Class for the Subject entity
 Author: Mathew Fortuin -219069514
 Date: 8/08/2022
*/

import org.springframework.util.StringUtils;
import za.ac.cput.Entity.Subject;
import za.ac.cput.Util.GenericHelper;

public class SubjectFactory {

    public static Subject createSubject(String subjectID, String subjectName,Integer subjectCredit, String lecturerID)
    {

        if(!StringUtils.hasLength(subjectID))
            throw new IllegalArgumentException("Subject ID was not provided");
        if(!StringUtils.hasLength(subjectName))
            throw new IllegalArgumentException("Subject Name was not provided");
        if(subjectCredit.equals(null))
            throw new IllegalArgumentException("Subject Credit was not provided");
        if(!StringUtils.hasLength(lecturerID))
            throw new IllegalArgumentException("Lecturer ID was not provided");




       return new Subject.Builder()
               .setSubjectID("IMN32")
               .setSubjectName("Information Management")
               .setSubjectCredit(36)
               .setLecturerID("FA12")
                .build();


    }
}
