package com.todorov.cardealer.service.services.implementations;

import com.todorov.cardealer.data.models.Car;
import com.todorov.cardealer.data.repositories.CarRepository;
import com.todorov.cardealer.service.models.CarServiceModel;
import com.todorov.cardealer.service.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ModelMapper modelMapper, CarRepository carRepository) {
        this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }

    @Override
    public CarServiceModel save(CarServiceModel model) {
        this.carRepository.saveAndFlush(this.modelMapper.map(model, Car.class));
        return model;
    }

    @Override
    public List<CarServiceModel> getCars() {
        return this.carRepository.findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CarServiceModel.class))
                .collect(Collectors.toList());
    }
}
