package com.example.carsales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarsEntity, Long> {
}
