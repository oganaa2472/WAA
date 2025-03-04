package com.miu.demo.controller;

import com.miu.demo.domain.Logger;
import com.miu.demo.repository.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LoggerController {

    @Autowired
    private LoggerRepo loggerRepository;

    @GetMapping
    public ResponseEntity<List<Logger>> getAllLogs() {
        return ResponseEntity.ok(loggerRepository.findAll());
    }
}