package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CityRestController {

    @Autowired
    CityService cityService;

    @GetMapping(path = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    City getCityByName(@RequestParam String name) {
        return cityService.findByCityName(name);
    }


}
