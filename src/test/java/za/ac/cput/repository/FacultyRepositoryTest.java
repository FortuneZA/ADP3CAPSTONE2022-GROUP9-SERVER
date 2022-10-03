package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Faculty;
import za.ac.cput.factory.FacultyFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class FacultyRepositoryTest {
    private static FacultyRepository facultyRepository = FacultyRepository.getRepository();
    private  static Faculty faculty = FacultyFactory.createFaculty("Engineering","engineering@cput.ac.za");

    @Test
    void a_create() {
        Faculty created = facultyRepository.create(faculty);
        assertEquals(faculty.getFacultyID(), created.getFacultyID());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Faculty read = facultyRepository.read(faculty.getFacultyID());
        assertNotNull(read);
        System.out.println("Read: "+ read);

    }

    @Test
    void c_update() {
        Faculty updated = new Faculty.Builder().copy(faculty).setFacultyName("Engineering & the Built Environment")
                            .setFacultyEmail("info@cput.ac.za")
                            .build();
        assertNotNull(facultyRepository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void e_delete() {
        boolean success = facultyRepository.delete(faculty.getFacultyID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Get all");
        System.out.println(facultyRepository.getAll());
    }
}