package za.ac.cput.service.impl;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Test;
import za.ac.cput.repository.impl.ITestRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestService implements ITestService
{

    @Autowired
    private ITestRepository   testRepository;

    @Override
    public Test create(Test test)
{
return this.testRepository.save(test);
}

    @Override
    public Test read(String testId)
{
return (Test) this.testRepository.findById(testId).orElseGet(null);
}

    @Override
    public Test update(Test test)
    {
        if(this.testRepository.existsById(test.getTestId()))
        {
            return this.testRepository.save(test);
        }

        return null;
    }

    @Override
    public boolean delete(String id)
    {
        this.testRepository.deleteById(id);

        if(this.testRepository.existsById(id)) return false;
        else return true;
    }

  @Override
  public Set<Object> getAll()
{
return this.testRepository.findAll().stream().collect(Collectors.toSet()); 
}

}
