package com.example.demo.repo;

import com.example.demo.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    abstract City findByName(String name);

}
