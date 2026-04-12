package com.srini.regressionframework.service;

import com.srini.regressionframework.repository.ExecutionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private ExecutionResultRepository executionResultRepository;

    public Map<String, Object> getDetails() {

        Map<String, Object> report = new HashMap<>();

        long total = executionResultRepository.count();
        long passed = executionResultRepository.countByStatus("PASS");
        long failed = executionResultRepository.countByStatus("FAIL");

        double passRate = total == 0 ? 0 : (passed * 100.0 / total);
        double failRate = total == 0 ? 0 : (failed * 100.0 / total);

        report.put("total", total);
        report.put("passed", passed);
        report.put("failed", failed);
        report.put("passRate", Math.round(passRate * 100.0) / 100.0);
        report.put("failRate", Math.round(failRate * 100.0) / 100.0);

        return report;
    }
}