package com.example.Passport.mycontroller;

import com.example.Passport.Entities.Person;
import com.example.Passport.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class maincontroller {
    @Autowired
    private PersonService personService;

    @GetMapping("/home")
    public String home()
    {
        return "this is home page";
    }

    @GetMapping("/persons")
    public List<Person> getPersons()
    {
        return this.personService.getPersons();
    }

    @GetMapping("/persons/{aadharId}")
    public Optional<Person> getPerson(@PathVariable String aadharId)
    {
        return this.personService.getPerson(Integer.parseInt(aadharId));
    }

    @PostMapping(value = "/persons",consumes = "application/json")
    public Person addPerson(@RequestBody Person person)
    {
        return this.personService.addPerson(person);
    }

    @PutMapping(value = "/persons",consumes = "application/json")
    public Person updatePerson(@RequestBody Person person)
    {
        return this.personService.updatePerson(person);
    }

    @DeleteMapping("/persons/{aadharId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable String aadharId)
    {
        try
        {
            this.personService.deletePerson(Integer.parseInt(aadharId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
