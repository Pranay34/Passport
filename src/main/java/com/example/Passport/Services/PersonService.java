package com.example.Passport.Services;

import com.example.Passport.Entities.Person;

import java.util.List;
import java.util.Optional;


public interface PersonService {
    List<Person> getPersons();

    Optional<Person> getPerson(int aadharId);

    Person addPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(int parseInt);

}
