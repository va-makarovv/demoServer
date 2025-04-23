package com.example.demoServer.rest.controller;

import com.example.demoServer.domain.Car;
import com.example.demoServer.rest.dto.CarDto;

import java.util.List;


public interface CarController {
    CarDto getById(long id);
    List<CarDto> getAll();

    List<CarDto> findCarByMark(String mark);
    List<CarDto> findCarsByCostBetween(int lowCost, int highCost);

    CarDto insert(CarDto car);
    CarDto update(CarDto car);
    void deleteByID(long id);
}
