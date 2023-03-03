package com.example.dream11.services;

import com.example.dream11.configuration.ChangeDbConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    ChangeDbConfiguration changeDbConfiguration;
    public void changeDb(String uri) {
        changeDbConfiguration.changeDatabaseUri(uri);
    }
}
