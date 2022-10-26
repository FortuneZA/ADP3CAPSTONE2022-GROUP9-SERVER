package za.ac.cput.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;
import za.ac.cput.service.impl.SystemAdminService;

import java.util.Set;

@RestController
@RequestMapping("/systemAdmin")
public class SystemAdminController {

    @Autowired
    SystemAdminService systemAdminService;

    @PostMapping("/create")
    public SystemAdmin create(@RequestBody SystemAdmin systemAdmin) {
        SystemAdmin newSystemAdmin = SystemAdminFactory.createSystemAdmin(systemAdmin.getAdminName(), systemAdmin.getAdminEmail());
    return systemAdminService.create(newSystemAdmin);
    }

    @GetMapping("/read/{id}")
    public SystemAdmin read(@PathVariable String id){
        return systemAdminService.read(id);
    }

    @PostMapping("/update")
    public SystemAdmin update(@RequestBody SystemAdmin systemAdmin){

        return systemAdminService.update(systemAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return systemAdminService.delete(id);
    }

    @GetMapping("/getall")
    public Set<SystemAdmin> getAll(){
        return systemAdminService.getAll();}
}
