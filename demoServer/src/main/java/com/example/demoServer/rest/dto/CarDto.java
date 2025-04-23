package com.example.demoServer.rest.dto;

import com.example.demoServer.domain.Car;
import lombok.Builder;


@Builder
public class CarDto {
    private String mark;
    private int cost;

    public static CarDto toDto(Car car){

        return CarDto.builder().mark(car.getMark()).cost(car.getCost()).build();
    }

    public static Car fromDto(CarDto dto){
        return Car.builder().mark(dto.mark).cost(dto.cost).build();

    }
}
