package com.srini.regressionframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    private ExecutionService executionService;

    @Scheduled(fixedRate = 60000)
    public void runScheduledTests() {
        executionService.runAllTests();
        System.out.println("Scheduled execution triggered");
    }
}