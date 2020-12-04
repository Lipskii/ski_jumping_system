package com.lipskii.ski_jumping_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectionTest {

    @GetMapping("/connection_test")
    public String connectionTest(){
        return "helloworld";

    }
}
