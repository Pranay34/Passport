package com.example.Passport.dao;

import com.example.Passport.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyDao extends JpaRepository<Person, Integer>{
}
