package com.springboot.controller;

import com.springboot.dao.Dao;
import com.springboot.pojo.Person;
import com.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    Dao dao;

    @GetMapping("/find")
    @ResponseBody
    public List<Person> findAll() {
        return dao.findAll();
    }
}
