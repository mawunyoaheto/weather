package com.raymond.practice.weatherapi.controller;

import com.raymond.practice.weatherapi.entity.Weather;
import com.raymond.practice.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path = "/api/v1/weather")
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping(path = "{weatherId}")
    public ResponseEntity<Weather> getWeather(@PathVariable("weatherId") int weatherId) {
        return new ResponseEntity<>(weatherService.getWeather(weatherId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Weather>> getAllWeather(
            @RequestParam(name="pageNo",defaultValue = "0",required = false) Integer pageNo,
            @RequestParam(name="pageSize",defaultValue = "10",required = false) Integer pageSize,
            @RequestParam(name="sort",defaultValue = "id",required = false) String sort,
            @RequestParam(name="city", required = false) String city,
            @RequestParam(name="date", required = false) LocalDate date) {
        List<Weather> weatherList = weatherService.getAllWeather(pageNo, pageSize, sort, city, date);
        return new ResponseEntity<>(weatherList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {
        return new ResponseEntity<>(weatherService.addWeather(weather), HttpStatus.CREATED);
    }
}
