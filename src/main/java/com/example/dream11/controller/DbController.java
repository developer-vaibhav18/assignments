package com.example.dream11.controller;

import com.example.dream11.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {
    @Autowired
    DbService dbService;
    @PostMapping("/changeDb")
    public void changeDb(@RequestBody String uri) {
        dbService.changeDb(uri);
    }
}
