package com.example.carsales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carsales.CarsEntity;

public interface CarRepository extends JpaRepository<CarsEntity, Long> {
}
