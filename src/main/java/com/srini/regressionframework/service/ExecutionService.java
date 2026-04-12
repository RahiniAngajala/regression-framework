package com.srini.regressionframework.service;
import org.springframework.transaction.annotation.Transactional;
import com.srini.regressionframework.entity.ExecutionResult;
import com.srini.regressionframework.entity.TestCase;
import com.srini.regressionframework.repository.ExecutionResultRepository;
import com.srini.regressionframework.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ExecutionService {

    @Autowired
    private ExecutionResultRepository executionResultRepository;

    @Autowired
    private TestCaseRepository testCaseRepository;
    @Transactional
    public void runAllTests() {

        // 🔹 Unique run ID for grouping
        String runId = UUID.randomUUID().toString();

        // 🔹 Fetch all test cases
        List<TestCase> testCases = testCaseRepository.findAll();

        // 🔹 Thread pool for parallel execution
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (TestCase tc : testCases) {

            executor.submit(() -> {

                ExecutionResult result = new ExecutionResult();

                result.setTestCaseId(tc.getId());
                result.setExecutionTime(LocalDateTime.now());
                result.setRunId(runId);

                try {
                    boolean passed = executeTest(tc);

                    result.setStatus(passed ? "PASS" : "FAIL");
                    result.setErrorMessage(passed ? null : "Assertion failed");

                } catch (Exception e) {
                    result.setStatus("FAIL");
                    result.setErrorMessage(e.getMessage());
                }

                // 🔹 Save result to DB
                executionResultRepository.saveAndFlush(result);
            });
        }

        executor.shutdown();

        try {
            // 🔹 Wait for all threads to finish
            while (!executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                System.out.println("Waiting for test execution to complete...");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Execution completed. RUN ID = " + runId);
    }

    // ⭐ DUMMY TEST EXECUTION LOGIC
    private boolean executeTest(TestCase tc) {

        // Replace later with Selenium / API automation logic
        return Math.random() > 0.3;
    }
}