package za.ac.cput.Factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Subject;

import static org.junit.jupiter.api.AssertNotEquals.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SubjectFactoryTest {

    //OBJECT CREATION
    Subject subject = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");

    //OBJECT EAQUALITY
    @Test
    public void ObjectEquality()
    {
        Subject subject2 = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");

        assertNotEquals(subject2,subject);
    }

    //OBJECT IDENTITY
    @Test
    public void ObjectIdentity()
    {
        Subject subject2=subject;

        assertEquals(subject2,subject);
    }

    //TIMEOUT
    @Test
    public void Timeout()
    {
        ObjectIdentity();
    }

    //DISABLED
    @Test
    @Disabled
    public void Disabled()
    {
        Subject subject2 = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");

        assertEquals(subject2,subject);
    }

    //BUILD VERIFICATION
    @Test
    public void TestNull()
    {
        Subject subject2 = SubjectFactory.createSubject("INM351","Information Management",36,"AF10");
        assertNotEquals(subject2,null);
    }

}
