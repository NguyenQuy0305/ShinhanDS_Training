package com.example.springboot_demo2.service.impl;

import com.example.springboot_demo2.entity.Person;
import com.example.springboot_demo2.repository.PersonRepository;
import com.example.springboot_demo2.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonRepository personRepository;

    @Override
    public int countPerson() {
        return personRepository.count();
    }

    @Override
    public int insertPerson(Person person) {
        return personRepository.insert(person);
    }
}
