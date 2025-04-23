package com.example.demoServer.rest.controller;

import com.example.demoServer.rest.dto.CarDto;
import com.example.demoServer.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// отправка http запросов

@RestController // позволяет использовать json, отправка и принятие запросов


@RequiredArgsConstructor

public class CarControllerImpl implements CarController{

    private final CarService carService;

    @GetMapping(path = "/car/{id}")
    @Override
    public CarDto getById(@PathVariable(name = "id") long carId) {
        return CarDto.toDto(carService.getById(carId));
    }

    @GetMapping(path = "/car")
    @Override
    public List<CarDto> getAll() {
        return carService.getAll().stream().map(CarDto::toDto).toList();
        //stream - преобразование данных в поток и применени к каждому из ни х дествия
    }

    @GetMapping(path = "/car/{mark}")
    @Override
    public List<CarDto> findCarByMark(String mark) {
        return carService.findCarByMark(mark).stream().map(CarDto::toDto).toList();
    }

    @GetMapping(path = "/car/cost-between")
    @Override
    public List<CarDto> findCarsByCostBetween(@RequestParam(name = "low") int lowCost,
                                           @RequestParam(name = "high") int highCost) {
        return carService.findCarsByCostBetween(lowCost,highCost).stream().map(CarDto::toDto).toList();
    }

    @PostMapping(path = "/car")
    @Override
    public CarDto insert(@RequestBody CarDto car) {
        return CarDto.toDto(carService.insert(CarDto.fromDto(car)));
    }


    @PutMapping(path = "/car")
    @Override
    public CarDto update(@RequestBody CarDto car) {
        return CarDto.toDto(carService.update(CarDto.fromDto(car)));
    }

    @DeleteMapping(path = "/car/{id}")
    @Override
    public void deleteByID(@PathVariable long id) {
        carService.deleteByID(id);
    }
}
