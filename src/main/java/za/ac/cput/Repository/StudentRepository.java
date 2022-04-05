package za.ac.cput.Repository;
import za.ac.cput.Entity.Student;
/*
Student.java
Repository for Student
Author: Themba Kanyile 217238173
Date : 23 March 2022
 */

import java.util.HashSet;
import java.util.Set;
public class StudentRepository implements IStudentRepository
{

    private static StudentRepository repository = null;
    private Set<Student> studentDB= null;

    private StudentRepository() {
        studentDB = new HashSet<Student>();
    }

    public static StudentRepository getRepository(){
        if(repository == null)
            repository = new StudentRepository();
        return repository;
    }

    @Override
    public Student create(Student student) {
        boolean success = this.studentDB.add(student);
        if(!success)
            return null;

        return student;
    }

    @Override
    public Student read(String StudentId) {

        for (Student student : this.studentDB) {
            String studentId;
            if (student.getStudentId().equalsIgnoreCase(StudentId))
                return student;
        }

        return null;
    }

    @Override
    public Student update(Student student) {
        Student preUpdate = read(student.getStudentId());

        if (preUpdate != null) {
            this.studentDB.remove(preUpdate);
            this.studentDB.add(student);
            return student;
        }

        return null;
    }

    @Override
    public boolean delete(String studentId) {
        Student studentToDelete = read(studentId);

        if (studentToDelete != null) {
            this.studentDB.remove(studentToDelete);
            return true;
        }
        return false;
    }

    @Override
    public Set<Student> getAll() {
        return studentDB;
    }

}
