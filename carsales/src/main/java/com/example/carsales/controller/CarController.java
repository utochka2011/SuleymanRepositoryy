package com.example.carsales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.carsales.CarService;
import com.example.carsales.CarsEntity;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/get-all")
    public List<CarsEntity> findAll() {
        return carService.findAllCars();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarsEntity findById(@PathVariable Long id) {
        return carService.findCarById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    @PostMapping("/save")
    public void saveCar(@RequestBody CarsEntity carEntity) {
        carService.saveCar(carEntity);
    }
}
