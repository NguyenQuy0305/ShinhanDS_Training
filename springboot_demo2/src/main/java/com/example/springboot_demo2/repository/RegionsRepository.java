package com.example.springboot_demo2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegionsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


}
