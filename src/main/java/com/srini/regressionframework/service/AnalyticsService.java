package com.srini.regressionframework.service;

import com.srini.regressionframework.dto.AnalyticsResponse;
import com.srini.regressionframework.repository.ExecutionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @Autowired
    private ExecutionResultRepository executionResultRepository;

    public AnalyticsResponse getOverallAnalytics() {

        long total = executionResultRepository.count();
        long passed = executionResultRepository.countByStatus("PASS");
        long failed = executionResultRepository.countByStatus("FAIL");

        return new AnalyticsResponse(total, passed, failed);
    }
}