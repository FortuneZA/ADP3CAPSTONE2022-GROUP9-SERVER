package za.ac.cput.controller.impl;

/* * Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date:13 October 2022
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.TestModel;
import za.ac.cput.service.impl.TestModelService;

import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestModelController {

    @Autowired
    private TestModelService testModelService;


    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public TestModel create(@RequestBody TestModel test )
    {
        return testModelService.create(test);
    }


    @GetMapping("/read/{id}")
    public TestModel read(@PathVariable String id)
    {
        return testModelService.read(id);
    }

    @PostMapping("/update")
    public TestModel update(@RequestBody TestModel test )
    {
        return testModelService.update(test);
    }


    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id)
    {
        return testModelService.delete(id);
    }
@GetMapping("/getAll")
    //getAll
    public Set<TestModel> getAll()
    {
        return testModelService.getAll();
    }
}
