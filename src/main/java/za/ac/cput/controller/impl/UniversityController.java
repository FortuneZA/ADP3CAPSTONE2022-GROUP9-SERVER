package za.ac.cput.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.University;
import za.ac.cput.factory.UniversityFactory;
import za.ac.cput.service.impl.UniversityService;

import java.util.Set;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @PostMapping("/create")
    public University create(@RequestBody University university) {
        University newUniversity= UniversityFactory.createUniversity(university.getUniversityName(), university.getEmail());
        return universityService.create(newUniversity);
    }

    @GetMapping("/read/{university}")
    public University read(@PathVariable University university) {
        return universityService.read(university.getUniversityId());
    }

    @PostMapping("/update")
    public University update(@RequestBody University university) {
        return universityService.update(university);
    }

    @DeleteMapping("/delete/{university}")
    public boolean delete(@PathVariable University university) {
        return universityService.delete(university.getUniversityId());
    }

    @GetMapping("/getall")
    public Set<University> getAll() {
        return universityService.getAll();
    }
}
