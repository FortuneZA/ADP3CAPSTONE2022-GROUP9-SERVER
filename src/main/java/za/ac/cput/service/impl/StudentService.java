package za.ac.cput.service.impl;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Student;
import za.ac.cput.repository.impl.IStudentRepository;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {


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
        return (Student) this.studentRepository.findById(studentId).orElseGet(null);
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
    public Set<Object> getAll() {return this.studentRepository.findAll().stream().collect(Collectors.toSet()); }

}
