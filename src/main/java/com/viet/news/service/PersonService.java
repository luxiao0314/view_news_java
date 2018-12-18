package com.viet.news.service;

import com.viet.news.dao.Dao;
import com.viet.news.entity.Person;
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
