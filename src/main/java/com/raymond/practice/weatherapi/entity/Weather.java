package com.raymond.practice.weatherapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date;
    private float lat;
    private float lon;
    private String city;
    private String state;
    @Column(length=510)
    @ElementCollection
    private ArrayList<Double> temperatures;
}
