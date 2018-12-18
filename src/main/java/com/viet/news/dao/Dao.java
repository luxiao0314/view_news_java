package com.viet.news.dao;
 
import com.viet.news.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface Dao extends JpaRepository<Person, String>{

}
