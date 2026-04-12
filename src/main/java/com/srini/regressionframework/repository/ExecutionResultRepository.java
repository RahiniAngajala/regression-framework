package com.srini.regressionframework.repository;

import com.srini.regressionframework.entity.ExecutionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutionResultRepository extends JpaRepository<ExecutionResult, Long> {

    // 🔹 for FAIL / PASS filtering
    List<ExecutionResult> findByStatus(String status);

    // 🔹 for run-wise results
    List<ExecutionResult> findByRunId(String runId);

    // 🔹 for analytics
    long countByStatus(String status);
}