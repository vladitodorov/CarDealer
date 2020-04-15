package com.todorov.cardealer.service.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class CarServiceModel {
    private String model;
    private String brand;
    private String engine;
    private Integer year;
}
