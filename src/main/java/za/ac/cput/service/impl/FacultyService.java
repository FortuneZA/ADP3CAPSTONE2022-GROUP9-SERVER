package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Faculty;
import za.ac.cput.repository.impl.IFacultyRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*FacultyService.java
FacultyService implementation
Author: Mawande Langa (219074054)
Date: 07/10/2022

 */
@Service
public class FacultyService implements IFacultyService {
    @Autowired
    private IFacultyRepository facultyRepository;
    private static FacultyService facultyService = null;

    public static FacultyService getFacultyService(){
        if(facultyService == null){
            facultyService = new FacultyService();
        }
        return  facultyService;
    }
    @Override
    public Faculty create(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    @Override
    public Faculty read(String facultyID) {
        return this.facultyRepository.findById(facultyID).orElse(null);
    }

    @Override
    public Faculty update(Faculty faculty) {
        if(this.facultyRepository.existsById(faculty.getFacultyID())){
            return this.facultyRepository.save(faculty);
        }
        return null;
    }

    @Override
    public boolean delete(String facultyID) {
        this.facultyRepository.deleteById(facultyID);
        if(this.facultyRepository.existsById(facultyID)){
            return false;
        }
        return true;
    }

    @Override
    public Set<Faculty> getAll() {
        return this.facultyRepository.findAll().stream().collect(Collectors.toSet());
    }
}
