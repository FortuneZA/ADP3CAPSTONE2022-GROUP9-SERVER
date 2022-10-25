/*
package za.ac.cput.controller.impl;
*/
/* * FacultyController.java
 * Controller for the Faculty
 * Author: Mawande Langa(219074054)
 * Date: 09/10/2022
 * *//*


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Faculty;
import za.ac.cput.service.impl.FacultyService;

import java.util.Set;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    //Create
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }

    //read
    @GetMapping("/read/{id}")
    public Faculty read(@PathVariable String id){
        return facultyService.read(id);
    }

    //Update
    @PostMapping("/update")
    public Faculty update(@RequestBody Faculty faculty){
        return facultyService.update(faculty);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id){
        return  facultyService.delete(id);
    }

    //Get all
    @GetMapping("/getAll")
    public Set<Faculty> getAll(){
        return facultyService.getAll();
    }
}
*/
