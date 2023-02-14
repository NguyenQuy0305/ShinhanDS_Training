package com.example.springboot_demo2.repository;

import com.example.springboot_demo2.entity.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonRepository {
    @Select("select count(1) from PERSON")
    int count();

    @Insert("INSERT INTO PERSON (full_name, date_of_birth) VALUES (#{fullName}, #{dateOfBirth})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Person person);
}
