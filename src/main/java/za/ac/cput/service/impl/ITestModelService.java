package za.ac.cput.service.impl;


import za.ac.cput.entity.TestModel;
import za.ac.cput.service.IService;

import java.util.Set;




public interface ITestModelService extends IService<TestModel,String> {

    Set<TestModel> getAll();
}
