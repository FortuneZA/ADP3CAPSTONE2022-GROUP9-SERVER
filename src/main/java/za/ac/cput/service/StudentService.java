package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Course;
import za.ac.cput.repository.impl.ICourseRepository;

import java.util.Set;
import java.util.stream.Collectors;
/*
 * Name:Themba
 * Surname:Khanyile
 * StudentNumber:217238173
 * Date: 12 October 2022
 */
@Service
public class StudentService implements IStudentService 
{
  @Autowired
    private IStudentRepository   studentRepository;
    private static StudentService service = null;

    public static StudentService getService()
    {
        if(service == null)
        {
            service = new StudentService();
        }

        return service;
    }

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
  public Set<Student> getAll() {return this.studentRepository.findAll().stream().collect(Collectors.toSet()); }
}
