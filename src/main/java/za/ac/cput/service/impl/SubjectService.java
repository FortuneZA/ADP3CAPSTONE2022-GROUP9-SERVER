package za.ac.cput.service.impl;

/*
SubjectService.java
Author: Mathew Fortuin (219069514)
Date: 21/8/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Subject;
import za.ac.cput.repository.impl.ISubjectRepository;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectService implements ISubjectService {


@Autowired
private ISubjectRepository subjectRepository;
private static SubjectService service = null;

public static SubjectService getService() {
    if(service == null)
    {
        service = new SubjectService();
    }

    return service;
}

    @Override
    public Subject create(Subject subject){return this.subjectRepository.save(subject);}

    @Override
    public Subject read(Long subjectId){return this.subjectRepository.findById(subjectId).orElseGet(null);}

    @Override
    public Subject update(Subject subject)
    {
        if(this.subjectRepository.existsById(subject.getSubjectID()))
        {
            return this.subjectRepository.save(subject);
        }

        return null;
    }

    @Override
    public boolean delete(Long id){
        this.subjectRepository.deleteById(id);
        if(this.subjectRepository.existsById(id)) return false;
        else return true;
    }

    @Override
    public Set<Subject> getAll() {return this.subjectRepository.findAll().stream().collect(Collectors.toSet());}



}
