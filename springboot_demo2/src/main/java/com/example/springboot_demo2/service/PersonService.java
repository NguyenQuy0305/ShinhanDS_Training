package com.example.springboot_demo2.service;

import com.example.springboot_demo2.entity.Person;

public interface PersonService {
    int countPerson();

    int insertPerson(Person person);
}
