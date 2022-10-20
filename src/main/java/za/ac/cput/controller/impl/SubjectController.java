package za.ac.cput.controller.impl;

/*
 * SubjectController.java
 * Controller for the Subject service
 * Author: Mathew Fortuin (219069514)
 * Date: 4 October 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Subject;
import za.ac.cput.repository.impl.ISubjectRepository;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectRepository subjectRepository;

    //Create subject
    @PostMapping(value ="/create")
    public Subject create(@RequestBody Subject subject)
    {
        return subjectRepository.save(subject);
    }

    //Read subject
    @GetMapping("/read")
    List<Subject> getSubjects(){return subjectRepository.findAll();}

    //Update subject
    @PutMapping("/update/{subjectID}")
    Subject updateSubject(@RequestBody Subject newSubject,@PathVariable String subjectID)
    {
        return subjectRepository.findById(subjectID)
                .map(subject -> {
                    subject.setSubjectID(newSubject.getSubjectID());
                    subject.setSubjectName((newSubject.getSubjectName()));
                    subject.setSubjectCredit((newSubject.getSubjectCredit()));
                    subject.setLecturerID(newSubject.getLecturerID());

                    return subjectRepository.save(subject);
                }).orElseThrow(()->new RuntimeException());
    }
    //Delete subject
    @DeleteMapping("/delete/{subjectID}")
    String deleteSubject(@PathVariable String subjectID)
    {
        if(!subjectRepository.existsById(subjectID))
        {
            throw new IllegalArgumentException("Subject not found.");
        }
        subjectRepository.deleteById(subjectID);
        return "Subject with id: "+subjectID+"has been deleted successfully.";
    }

    //getAll
    //public Set<Subject> getAll() {return subjectService.getAll();}
}

