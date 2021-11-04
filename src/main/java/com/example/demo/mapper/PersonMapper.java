package com.example.demo.mapper;

import com.example.demo.model.Person;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface PersonMapper {

    public Person getPerson(Integer id);
}
