package com.example.weather.controller;

import com.example.weather.service.WeatherService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CurrentWeatherController {

    private final WeatherService weatherService;

    @GetMapping(value = {"/current-weather","/current-weather/{location}"})
    public String getCurrentWeather(@PathVariable Optional<String> location,Model model) {
        String city;
        String country;
        if (location.isPresent()) {
            city = location.get().split(",")[0];
            country = location.get().split(",")[1];
        } else {
            city = "Melbourne";
            country = "AU";
        }
        model.addAttribute("currentWeather", weatherService.getCurrentWeather(city,country));
        return "current-weather";
    }

    public CurrentWeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
