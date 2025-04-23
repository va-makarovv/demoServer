package com.example.demoServer.service;

import com.example.demoServer.domain.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    Car getById(long id);
    List<Car> getAll();

    List<Car> findCarByMark(String mark);
    List<Car> findCarsByCostBetween(int lowCost, int highCost);

    Car insert(Car car);
    Car update(Car car);
    void deleteByID(long id);
}
