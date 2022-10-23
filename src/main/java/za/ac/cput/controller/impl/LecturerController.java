package za.ac.cput.controller.impl;

/*
Name: Cameron Henry Noemdo
Student number: 219115443
File: LecturerController.java
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Lecturer;
import za.ac.cput.factory.LecturerFactory;
import za.ac.cput.service.impl.LecturerService;

import java.util.Set;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @PostMapping("/create")
    public Lecturer create(@RequestBody Lecturer lecturer) {
        Lecturer newLecturer= LecturerFactory.createLecturer(lecturer.getFirstName(), lecturer.getMiddleName(), lecturer.getLastName(), lecturer.getLecturerEmail(), lecturer.getDepartmentId());
        return lecturerService.create(newLecturer);
    }

    @GetMapping("/read/{lecturer}")
    public Lecturer read(@PathVariable Lecturer lecturer) {
        return lecturerService.read(lecturer.getLecturerId());
    }



    @PostMapping("/update")
    public Lecturer update(@RequestBody Lecturer lecturer) {
        return lecturerService.update(lecturer);
    }


    @DeleteMapping("/delete/{lecturer}")
    public boolean delete(@PathVariable Lecturer lecturer) {
        return lecturerService.delete(lecturer.getLecturerId());
    }


    @GetMapping("/getall")
    public Set<Lecturer> getAll() {
        return lecturerService.getAll();
    }
}
