package za.ac.cput.service.impl;

import za.ac.cput.entity.Test;
import za.ac.cput.service.IService;
import java.util.Set;
/*Name:Themba
 *Surname:Khanyile
 *StudentNumber:217238173
 *Date: 13 October 2022
 */

public interface ITestService extends IService<Test,String>{
   
    Set<Object> getAll();
}
