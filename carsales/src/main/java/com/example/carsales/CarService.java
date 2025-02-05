package com.example.carsales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<CarsEntity> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<CarsEntity> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public void saveCar(CarsEntity carEntity) {
        carRepository.save(carEntity);
    }
}
