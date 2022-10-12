package za.ac.cput.service;
/*

 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.service.impl.LecturerService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LecturerServiceTest {

    private final Lecturer lecturer= LecturerFactory.createLecturer("Cameron","Henry","Noemdo","chn@cput.ac.za","ICT-ADP-321");

    private Lecturer lecturerCreated;

    @Autowired
    private LecturerService lecturerService;

    void createLecturer(Lecturer lec) {
        lecturerCreated=lecturerService.create(lec);
    }

    @Test
    void d_getAll()
    {
        Set<Lecturer> lecturerSet=lecturerService.getAll();
        System.out.println(lecturerSet);
    }

    @Test
    void a_create()
    {
        createLecturer(lecturer);
        assertEquals("Cameron",lecturerCreated.getFirstName());
        System.out.println("Created: "+lecturerCreated);
    }

    @Test
    void b_read()
    {
        createLecturer(lecturer);
        Lecturer lecturerRead= lecturerService.read(lecturerCreated.getLecturerId());
        System.out.println("Read: "+lecturerRead);
    }

    @Test
    void c_update()
    {
        createLecturer(lecturer);
        Lecturer lecturerUpdate=new Lecturer
                .Builder()
                .copy(lecturer)
                .setDepartmentId("ICT7800")
                .build();
        lecturerService.update(lecturerUpdate);
        System.out.println("Updated: "+lecturerUpdate);
    }

    @Test
    void e_delete()
    {
        createLecturer(lecturer);
        boolean delete=lecturerService.delete(lecturer.getLecturerId());
        assertTrue(delete);
    }


}
