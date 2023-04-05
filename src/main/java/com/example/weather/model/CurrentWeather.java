package com.example.weather.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CurrentWeather implements Serializable {

    private String city;
    private String country;
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;

}
