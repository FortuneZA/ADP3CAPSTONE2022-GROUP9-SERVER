package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.University;
import za.ac.cput.repository.impl.IUniversityRepository;

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
    public University read(String universityId) {
        return this.universityRepository.findById(universityId).orElseGet(null);
    }

    @Override
    public University update(University university) {
        if(this.universityRepository.existsById(university.getUniversityId()))
            return this.universityRepository.save(university);
        return null;
    }

    @Override
    public boolean delete(String universityId) {
        this.universityRepository.deleteById(universityId);
        if(this.universityRepository.existsById(universityId)) {
            throw new IllegalArgumentException("University not found.");
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
