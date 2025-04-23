package com.example.demoServer.repository;

import com.example.demoServer.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // озволяет увидеть репозиторий, вобрабатывать в себя
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findCarByMark(String mark);
    List<Car> findCarsByCostBetween(int lowCost, int highCost);


}
