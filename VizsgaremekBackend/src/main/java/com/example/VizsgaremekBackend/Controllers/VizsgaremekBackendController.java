package com.example.VizsgaremekBackend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VizsgaremekBackendController {
    @GetMapping("/User")
    public String User(){
        return "Felhasználó adatai, Felajánlott könyvei, Felkérések, Visszaigazolások";
    }
    @GetMapping("/Admin")
    public String Admin(){
        return "Admin adatai, Felhasználók adatai, Felajánlott könyvek, Felkérések, Visszaigazolások, Regisztráció kérések ";
    }
    @GetMapping("/Visitor")
    public String Visitor(){
        return "Felajánlott könyvek";
    }

}
