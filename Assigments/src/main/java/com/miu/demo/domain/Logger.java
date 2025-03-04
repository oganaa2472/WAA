package com.miu.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity

@Data
@NoArgsConstructor
@Table(name = "logger")
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;


    public Logger(String principle, String operation) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.principle = principle;
        this.operation = operation;
    }

    // Геттэр, сеттэрүүд
}
