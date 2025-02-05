package com.example.carsales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<CarsEntity> findAll() {
        return carService.findAllCars();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarsEntity findById(@PathVariable Long id) {
        return carService.findCarById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void saveCar(@RequestBody CarsEntity carEntity) {
        carService.saveCar(carEntity);
    }
}
