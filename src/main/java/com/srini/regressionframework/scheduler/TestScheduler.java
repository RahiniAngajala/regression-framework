package com.srini.regressionframework.scheduler;

import com.srini.regressionframework.service.ExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

    @Autowired
    private ExecutionService executionService;

    @Scheduled(fixedRate = 60000) // every 60 seconds
    public void scheduledRun() {
        executionService.runAllTests();
    }
}