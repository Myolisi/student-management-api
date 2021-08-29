package com.webtonic.student_management_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    // test to see if the api is alive
    @GetMapping
    private String ping(){
        return "Student Management v1";
    }
}
