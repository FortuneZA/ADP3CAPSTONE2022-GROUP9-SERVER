package za.ac.cput.Repository;
/*
        MarkRepositoryTest.java
        Author: Lefu Kumeke 218147856
        Date :03 April 2022
        */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Mark;
import za.ac.cput.Factory.MarkFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class MarkRepositoryTest {


    private static MarkRepository markRepository = MarkRepository.getRepository();
    private static Mark mark = MarkFactory.createMark("111", "Maths101", "5 May 2022");

    @Test
    void a_create() {
        Mark created = markRepository.create(mark);
        assertEquals(created.getMarkID(), mark.getMarkID());
        System.out.println("Created ID: " + created.getMarkID()+ "\nMark ID: " + mark.getMarkID() + "\n");
    }

    @Test
    void b_read() {
        Mark read = markRepository.read(mark.getMarkID());
        assertNotNull(read);
        System.out.println("Read: " + read + "\n");
    }

    @Test
    void c_update() {
        Mark updated = new Mark.Builder().copy(mark).setLectureID("999").setTestID("Mathematics1").setMarkDate("3 June 2022").build();
        assertNotNull(markRepository.update(updated));
        System.out.println("Updated (" + updated.getMarkID() + "): " + updated.getLectureID() + " " + updated.getTestID() + " "
                + updated.getMarkDate());
    }

    @Test
    void e_delete() {

        boolean deleted = markRepository.delete(mark.getMarkID());
        //assertTrue(true);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {

        System.out.println("\nDisplay all :" );
        System.out.println(markRepository.getAll() + "\n");
    }
}
