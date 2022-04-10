package za.ac.cput.impl;
import za.ac.cput.Entity.Student;
import za.ac.cput.Repository.IRepository;

import java.util.Set;
public interface IStudentRepository extends IRepository<Student, String>
{
    public Set<Student> getAll();
}
