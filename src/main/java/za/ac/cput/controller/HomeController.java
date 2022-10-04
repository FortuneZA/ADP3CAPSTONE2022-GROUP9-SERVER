package za.ac.cput.controller;

/*
 * HomeController.java
 * Controller to host  the Home directory
 * Author: Mathew Fortuin (219069514)
 * Date: 4 October 2022
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/","/home"})
    public String home(){
        return "Welcome to the Home Page!";
    }

}
