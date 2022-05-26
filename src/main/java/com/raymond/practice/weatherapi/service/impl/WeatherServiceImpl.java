package com.raymond.practice.weatherapi.service.impl;

import com.raymond.practice.weatherapi.entity.Weather;
import com.raymond.practice.weatherapi.exceptions.ResourceNotFoundException;
import com.raymond.practice.weatherapi.repository.WeatherRepository;
import com.raymond.practice.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public Weather getWeather(int weatherId) {
        return weatherRepository.findById(weatherId)
                .orElseThrow(()->new ResourceNotFoundException("Not Found"));
    }

    @Override
    public List<Weather> getAllWeather(Integer pageNo, Integer pageSize,
                                    String sort,String city, LocalDate date) {
        Pageable paging  = PageRequest.of(pageNo,pageSize, Sort.by(sort));
        Page<Weather> pagedResult = weatherRepository.findAll(paging);
        if(city!=null && date==null) {
           pagedResult = weatherRepository.getWeathersByCity(city,paging);
        }

        if(date!=null && city==null) {
            pagedResult = weatherRepository.getWeathersByDate(date,paging);
        }

        if(date!=null && city!=null){
           pagedResult = weatherRepository.getWeathersByCityAndDate(city,date,paging);
        }

        if(pagedResult.hasContent()){
            return pagedResult.getContent();
        }else {
            return new ArrayList<Weather>();
        }
    }

    @Override
    public Weather addWeather(Weather weather) {
        System.out.println("Weather Service: "+weather.getCity());
        return weatherRepository.save(weather);
    }
}
