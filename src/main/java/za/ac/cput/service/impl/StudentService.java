package za.ac.cput.service.impl;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Student;
import za.ac.cput.Repository.impl.IStudentRepository;
import za.ac.cput.service.impl.IStudentService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements studentRepository
{

    @Autowired
    private IStudentRepository   studentRepository;

    @Override
    public Student create(Student student)
{
return this.studentRepository.save(student);
}

    @Override
    public Student read(String studentId)
{
return this.studentRepository.findById(studentId).orElseGet(null);
}

    @Override
    public Student update(Student student)
    {
        if(this.studentRepository.existsById(student.getStudentId()))
        {
            return this.studentRepository.save(student);
        }

        return null;
    }

    @Override
    public boolean delete(String id)
    {
        this.studentRepository.deleteById(id);

        if(this.studentRepository.existsById(id)) return false;
        else return true;
    }

  @Override
  public Set<Student> getAll() 
{
return this.studentRepository.findAll().stream().collect(Collectors.toSet()); 
}

}

