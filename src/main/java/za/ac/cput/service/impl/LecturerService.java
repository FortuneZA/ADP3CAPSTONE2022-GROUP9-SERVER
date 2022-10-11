package za.ac.cput.service.impl;
/*
    LecturerService.java
    Service for the Lecturer
    Author: Cameron Henry Noemdo (219115443)
    Date: 21 August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.repository.impl.ILecturerRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LecturerService implements ILecturerService {

    @Autowired
    private ILecturerRepository lecturerRepository;

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer read(String lecturerId) {
        return this.lecturerRepository.findById(lecturerId).orElse(null);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        if(this.lecturerRepository.existsById(lecturer.getLecturerId()))
            return this.lecturerRepository.save(lecturer);
        return null;
    }

    @Override
    public boolean delete(String lecturerId) {
        this.lecturerRepository.deleteById(lecturerId);
        if(this.lecturerRepository.existsById(lecturerId)) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.lecturerRepository.findAll().stream().collect(Collectors.toSet());
    }
}
