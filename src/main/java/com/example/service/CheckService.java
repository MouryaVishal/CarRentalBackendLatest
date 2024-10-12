package com.example.service;

import com.example.model.CheckDatabase;
import com.example.repo.CheckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService {
    @Autowired
    private CheckRepo repo;
    public List<CheckDatabase>  findAllUser(){
        return repo.findAll();
    }
}
