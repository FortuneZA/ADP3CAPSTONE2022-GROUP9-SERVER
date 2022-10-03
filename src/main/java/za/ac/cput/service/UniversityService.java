package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.University;
import za.ac.cput.repository.impl.IUniversityRepository;
import za.ac.cput.service.impl.IUniversityService;

import java.util.Set;
import java.util.stream.Collectors;

/*
    UniversityService.java
    Service for the University
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */
@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private IUniversityRepository universityRepository;

    @Override
    public University create(University university) {
        return this.universityRepository.save(university);
    }

    @Override
    public University read(String universityName) {
        return this.universityRepository.findById(universityName).orElseGet(null);
    }

    @Override
    public University update(University university) {
        return create(university);
    }

    @Override
    public boolean delete(String universityName) {
        this.universityRepository.deleteById(universityName);
        if(this.universityRepository.existsById(universityName)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Set<University> getAll() {
        return this.universityRepository.findAll().stream().collect(Collectors.toSet());
    }
}
