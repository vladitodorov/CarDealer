package com.todorov.cardealer.data.repositories;

import com.todorov.cardealer.data.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

}
