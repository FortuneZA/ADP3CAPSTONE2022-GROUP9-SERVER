package za.ac.cput.Repository;
import za.ac.cput.Entity.Student;

import java.util.Set;
public interface IStudentRepository extends IRepository <Student, String>
{
    public Set<Student> getAll();
}
