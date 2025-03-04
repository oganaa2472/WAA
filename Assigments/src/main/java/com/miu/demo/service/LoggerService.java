package com.miu.demo.service;

import com.miu.demo.domain.Logger;
import com.miu.demo.repository.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepo loggerRepo;

    private static final String PRINCIPLE = "FakeUser"; // Түр зуурын хэрэглэгч

    public void logOperation(String operation) {
        Logger log = new Logger(PRINCIPLE, operation);
        loggerRepo.save(log);
    }
}
