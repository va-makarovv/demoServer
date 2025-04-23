package com.example.demoServer.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data // создание get/set/toString/Equals/hashCode
@Builder //
@Entity // создаёт эксземпляр класса как таблицы
@Table(name = "car") // изменение названия таблицы
public class Car {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // авто создание id инкремент - IDENTITY
    private final long id;

    @Column(name = "mark")
    private final String mark;

    @Column(name = "hp")
    private final double hp;

    @Column(name = "torque")
    private final double torque;

    @Column(name = "cost")
    private final int cost;

}
