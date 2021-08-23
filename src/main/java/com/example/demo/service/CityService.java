package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City findByCityName(String name){
         return cityRepository.findByName(name);
    }
}
