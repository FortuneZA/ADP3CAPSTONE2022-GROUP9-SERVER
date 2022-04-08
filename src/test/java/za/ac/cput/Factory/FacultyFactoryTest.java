package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Faculty;

import static org.junit.jupiter.api.Assertions.*;

class FacultyFactoryTest {
    @Test
    public void test(){
        Faculty faculty = FacultyFactory.createFaculty("Infor & Design","219074054@mycput.ac.za");
        System.out.println(faculty.toString());
        assertNotNull(faculty);
    }

}