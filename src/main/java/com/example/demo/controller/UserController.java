package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final CityRepository modelsRepository;

    @Autowired
    public UserController(CityRepository modelsRepository) {
        this.modelsRepository = modelsRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (model == null) {
            throw new RuntimeException("Model cannot be null");
        }

        model.addAttribute("title", "главная страница");
        return "home";
    }

    @PostMapping
    public String postHome(@RequestParam String city, @RequestParam String massage, Model model) {
        City models = new City(city,massage);
        modelsRepository.save(models);
        return "redirect:/history";
    }

    @GetMapping("/history")
    public String history(Model model) {
        Iterable<City> posts = modelsRepository.findAll();
        model.addAttribute("posts", posts);
        return "history";
    }

    @PostMapping("history/{id}/remove")
    public String delete(Model model, @PathVariable(value = "id") long id){

        City models =  modelsRepository.findById(id).orElseThrow();
        modelsRepository.delete(models);
        return "redirect:/history";
    }
}
