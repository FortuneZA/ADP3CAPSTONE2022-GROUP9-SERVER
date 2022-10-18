package za.ac.cput.service.impl;

import za.ac.cput.entity.Student;

import java.util.Set;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */

public interface IStudentService {
    Student create(Student student);

    Object read(String studentId);

    Student update(Student student);

    boolean delete(String id);

    Set<Object> getAll();
}
