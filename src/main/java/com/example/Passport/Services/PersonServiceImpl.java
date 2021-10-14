package com.example.Passport.Services;

import com.example.Passport.Entities.Person;
import com.example.Passport.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private MyDao myDao;

    public PersonServiceImpl() {

    }

    @Override
    public List<Person> getPersons()
    {

        return myDao.findAll();
    }

    @Override
    public Optional<Person> getPerson(int aadharId) {
        //return personDao.getOne(aadharId);
        Optional<Person> p= myDao.findById( aadharId);
        return p;

    }
   /* public Person getPerson(int aadharId) {
        //return personDao.getOne(aadharId);
        Optional<Person> p= personDao.findById( aadharId);
        return p;

    }*/

    @Override
    public Person addPerson(Person person) {
        myDao.save(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        myDao.save(person);
        return person;
    }

    @Override
    public void deletePerson(int parseInt) {
        Person entity = myDao.getOne(parseInt);
        myDao.delete(entity);
    }

}
