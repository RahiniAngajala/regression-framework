package com.srini.regressionframework.repository;

import com.srini.regressionframework.entity.TestCase; // ✅ IMPORTANT
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}