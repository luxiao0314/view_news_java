package com.springboot.dao;
 
import java.util.List;

import com.springboot.pojo.Person;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface Dao extends JpaRepository<Person, String>{

}
