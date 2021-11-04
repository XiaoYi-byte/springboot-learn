package com.example.demo.service.impl;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;

    public Person getPersonById(Integer id){
        return personMapper.getPerson(id);
    }

}
