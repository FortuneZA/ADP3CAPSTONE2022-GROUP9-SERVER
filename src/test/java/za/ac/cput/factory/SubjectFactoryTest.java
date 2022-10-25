package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Subject;
import za.ac.cput.factory.SubjectFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubjectFactoryTest {


    private final  Subject subject = SubjectFactory.createSubject("Information Management",36,"AF10");
    private final  Subject subject2 = SubjectFactory.createSubject("Information Systems",36,"WR10");

    private Subject subject3 = subject2;

    //Successful Create
    @Test
     void successfulCreateSubject()
    {
        assertAll(
                ()->assertNotNull(subject),
                ()->assertEquals("FA12",subject.getLecturerID())

        );
    }

    //Test Equality
    @Test
    void testEquality()
    {
        assertEquals(subject3,subject2);
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
       testEquality();
    }

    //Build Verification
    @Test
    public void TestNull()
    {
        Subject subject2 = SubjectFactory.createSubject("Information Management",36,"AF10");
        assertNotEquals(subject2,null);
    }

}
