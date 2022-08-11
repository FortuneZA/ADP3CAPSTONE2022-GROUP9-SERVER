package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Subject;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubjectFactoryTest {


    private final  Subject subject = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");
    private final  Subject subject2 = SubjectFactory.createSubject("ITS201","Information Systems",36,"WR10");

    private Subject subject1;

    //Successful Create
    @Test
     void successfulCreateSubject()
    {
        assertAll(
                ()->assertNotNull(subject),
                ()->assertEquals("INM351",subject.getSubjectID())
        );
    }

    //Failure create
    @Test
    void failCreateSubject()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()->subject1=SubjectFactory.createSubject("ITS201","Information Systems", 36,"WR10"));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().contains("Subject Name was not provided"));
    }

    //TIMEOUT
    @Test
    public void Timeout()
    {
        successfulCreateSubject();
    }

    //DISABLED
    @Test
    @Disabled
    public void Disabled()
    {
       failCreateSubject();
    }

    //Build Verification
    @Test
    public void TestNull()
    {
        Subject subject2 = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");
        assertNotEquals(subject2,null);
    }

}
