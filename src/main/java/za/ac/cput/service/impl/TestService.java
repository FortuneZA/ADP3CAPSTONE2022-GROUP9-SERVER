package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.TestModel;
import za.ac.cput.repository.impl.ITestModelRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestModelService implements ITestModelService
{

    @Autowired
    private ITestModelRepository   testModelRepository;

    @Override
    public TestModel create(TestModel test)
    {
        return this.testModelRepository.save(test);
    }


    @Override
    public TestModel read(String testId)
    {
        return (TestModel) this.testModelRepository.findById(testId).orElseGet(null);
    }



    @Override
    public TestModel update(TestModel test)
    {
        if(this.testModelRepository.existsById(test.getTestId()))
        {
            return this.testModelRepository.save(test);
        }

        return null;
    }

    @Override
    public boolean delete(String id)
    {
        this.testModelRepository.deleteById(id);

        if(this.testModelRepository.existsById(id)) return false;
        else return true;
    }

    @Override
    public Set<TestModel> getAll()
    {
        return this.testModelRepository.findAll().stream().collect(Collectors.toSet());
    }

}
