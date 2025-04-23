package com.example.demoServer.service;

import com.example.demoServer.domain.Car;
import com.example.demoServer.exception.CarAlreadyExistsException;
import com.example.demoServer.exception.CarNotFoundException;
import com.example.demoServer.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //создание данного класса при запуске
@RequiredArgsConstructor //добавляет в конструктор только поля final
public class CarServiceImpl implements CarService {

    private final
    CarRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Car getById(long id) {
        if (id > 0){
            repository.findById(id).orElseThrow(() ->
                    new CarNotFoundException("Car with id " + id + " was not found"));
        }
        throw new RuntimeException("Id must be higher than 0");
    }

    @Transactional(readOnly = true)

    @Override
    public List<Car> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findCarByMark(String mark) {
        return repository.findCarByMark(mark);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Car> findCarsByCostBetween(int lowCost, int highCost) {
        return repository.findCarsByCostBetween(lowCost,highCost);
    }

    @Transactional
    @Override
    public Car insert(Car car) {
        if (repository.existsById(car.getId())) throw new CarAlreadyExistsException("Car with id " + car.getId() + " already exists");
        return repository.save(car);
    }

    @Transactional

    @Override
    public Car update(Car car) {
        if (repository.existsById(car.getId())){
            return repository.save(car);
        }
        throw new CarNotFoundException("Car with id " +  car.getId() + "was not found");
    }

    @Transactional

    @Override
    public void deleteByID(long id) {

        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new CarNotFoundException("Car with id " +  id + "was not found");

        }

    }
}
