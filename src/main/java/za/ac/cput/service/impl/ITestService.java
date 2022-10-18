package za.ac.cput.service.impl;

import za.ac.cput.entity.Test;
import za.ac.cput.service.IService;
import java.util.Set;

/*

 */
public interface ITestService extends IService<Test,String>{
   
    Set<Object> getAll();
}
