package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Subject;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubjectFactoryTest {


    private final  Subject subject = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");
    private final  Subject subject2 = SubjectFactory.createSubject("ITS201","Information Systems",36,"WR10");

    private Subject subject3 = subject2;

    //Successful Create
    @Test
     void successfulCreateSubject()
    {
        assertAll(
                ()->assertNotNull(subject),
                ()->assertEquals("IMN32",subject.getSubjectID())
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
        Subject subject2 = SubjectFactory.createSubject("IMN32","Information Management",36,"AF10");
        assertNotEquals(subject2,null);
    }

}
