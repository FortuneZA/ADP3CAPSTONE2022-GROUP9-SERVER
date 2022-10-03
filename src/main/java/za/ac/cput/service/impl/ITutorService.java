package za.ac.cput.service.impl;

/*
    ITutorService.java
    Author: Devon Daniels (217299822)

 */
import za.ac.cput.entity.Tutor;
import za.ac.cput.service.IService;
import java.util.Set;

public interface ITutorService extends IService<Tutor,String> {
    Set<Tutor> getAll();
}
