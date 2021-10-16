package com.warugurudeveloper.Springboottutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  HelloController {
    //method to be executed you request mapping
    @GetMapping("/")
//    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcome too springboot camp";
    }
}
