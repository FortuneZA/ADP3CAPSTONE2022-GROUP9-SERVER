package za.ac.cput.controller.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.SystemAdmin;
import za.ac.cput.factory.SystemAdminFactory;
import za.ac.cput.service.impl.SystemAdminService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public SystemAdmin create(SystemAdmin systemAdmin) {
        SystemAdmin newSystemAdmin = SystemAdminFactory.createSystemAdmin(systemAdmin.getAdminName(), systemAdmin.getAdminEmail());
    return systemAdminService.create(newSystemAdmin);
    }

    @GetMapping("/read")
    public SystemAdmin read(@RequestBody SystemAdmin systemAdmin){
        return systemAdminService.read(systemAdmin.getAdminID());
    }

    @PostMapping("/update")
    public SystemAdmin update(@RequestBody SystemAdmin systemAdmin){
        return systemAdminService.update(systemAdmin);
    }

    @PostMapping
    public void delete(@RequestBody SystemAdmin systemAdmin){
        systemAdminService.delete(systemAdmin.getAdminID());
    }

    @GetMapping("/getall")
    public Set<SystemAdmin> getAll(){
        return systemAdminService.getAll();}
}
