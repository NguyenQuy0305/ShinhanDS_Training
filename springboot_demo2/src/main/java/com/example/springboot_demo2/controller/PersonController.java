package com.example.springboot_demo2.controller;

import com.example.springboot_demo2.entity.Person;
import com.example.springboot_demo2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/count")
    public int countPerson() {
        return personService.countPerson() != 0 ? personService.countPerson() : 0;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person newRecord = new Person();
            newRecord.setDateOfBirth(person.getDateOfBirth());
            newRecord.setFullName(person.getFullName());
            int result = personService.insertPerson(newRecord);
            return new ResponseEntity<>(newRecord, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
