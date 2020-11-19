package com.stark.springbootcircuitbreaker.controller;

import com.stark.springbootcircuitbreaker.service.SpringBootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringbootRestController {

    @Autowired
    private SpringBootServiceImpl springBootService;

    @GetMapping("/hello")
    public String getHelloMessage() throws InterruptedException {
        return springBootService.getMessage();
    }

}
