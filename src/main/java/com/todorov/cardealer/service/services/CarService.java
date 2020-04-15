package com.todorov.cardealer.service.services;

import com.todorov.cardealer.service.models.CarServiceModel;

import java.util.List;

public interface CarService {

    CarServiceModel save(CarServiceModel model);

    List<CarServiceModel> getCars();
}
