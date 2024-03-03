package com.geolidth.BackEnd.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
