package com.example.demo.service;

import com.example.demo.mapper.CityMapper;
import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;

public interface CityService {

        public City getById(Long id);

        public void saveCity(City city);
}
