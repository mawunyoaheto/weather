package com.raymond.practice.weatherapi.service;

import com.raymond.practice.weatherapi.entity.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherService {

    public Weather getWeather(int weatherId);
    public List<Weather> getAllWeather(Integer pageNo, Integer pageSize, String sort, String city, LocalDate date);
    public Weather addWeather(Weather weather);
}
