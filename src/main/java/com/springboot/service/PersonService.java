package com.springboot.service;

import com.springboot.dao.Dao;
import com.springboot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    Dao dao;

    public List<Person> findAll() {
        return dao.findAll();
    }
}
