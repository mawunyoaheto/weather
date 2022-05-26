package com.raymond.practice.weatherapi.repository;

import com.raymond.practice.weatherapi.entity.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    public Page<Weather> getWeathersByCity(String city, Pageable pageable);
    public Page<Weather> getWeathersByDate(LocalDate date, Pageable pageable);
    public Page<Weather> getWeathersByCityAndDate(String city, LocalDate date,Pageable pageable);
}
