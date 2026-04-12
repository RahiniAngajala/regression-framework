package com.srini.regressionframework.controller;
import com.srini.regressionframework.dto.AnalyticsResponse;
import com.srini.regressionframework.entity.ExecutionResult;
import com.srini.regressionframework.repository.ExecutionResultRepository;
import com.srini.regressionframework.service.ExecutionService;
import com.srini.regressionframework.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/execution")
public class ExecutionController {

    @Autowired
    private ExecutionResultRepository executionResultRepository;

    @Autowired
    private ExecutionService executionService;

    // ⭐ ADDED FOR MILESTONE 4
    @Autowired
    private AnalyticsService analyticsService;

    // 1. RUN TESTS
    @PostMapping("/run")
    public String runTests() {
        executionService.runAllTests();
        return "Execution Completed Successfully";
    }

    // 2. ALL RESULTS
    @GetMapping("/results")
    public List<ExecutionResult> getAllResults() {
        return executionResultRepository.findAll();
    }

    // 3. FAILURES ONLY
    @GetMapping("/failures")
    public List<ExecutionResult> getFailures() {
        return executionResultRepository.findByStatus("FAIL");
    }

    // 4. SUMMARY REPORT (DB + Analytics ready)
    @GetMapping("/summary")
    public String getSummary() {

        long total = executionResultRepository.count();
        long pass = executionResultRepository.countByStatus("PASS");
        long fail = executionResultRepository.countByStatus("FAIL");

        double passPercentage = (total == 0) ? 0 : (pass * 100.0 / total);

        return "TOTAL: " + total +
                " | PASS: " + pass +
                " | FAIL: " + fail +
                " | PASS%: " + String.format("%.2f", passPercentage);
    }

    // 5. RUN-WISE REPORT
    @GetMapping("/run/{runId}")
    public List<ExecutionResult> getByRunId(@PathVariable String runId) {
        return executionResultRepository.findByRunId(runId);
    }

    // ⭐ 6. MILESTONE 4 - ANALYTICS ENDPOINT (NEW ADDITION)
    @GetMapping("/analytics/summary")
    public AnalyticsResponse getAnalyticsSummary() {
        return analyticsService.getOverallAnalytics();
    }
}