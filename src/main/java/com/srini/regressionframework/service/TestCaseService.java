package com.srini.regressionframework.service;

import com.srini.regressionframework.entity.TestCase;
import com.srini.regressionframework.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ IMPORTANT
public class TestCaseService {

    @Autowired
    private TestCaseRepository repository;

    // 🔹 Add Test Case
    public TestCase addTestCase(TestCase testCase) {
        return repository.save(testCase);
    }

    // 🔹 Get All Test Cases
    public List<TestCase> getAllTestCases() {
        return repository.findAll();
    }

    // 🔹 Get Test Case by ID
    public TestCase getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 🔹 Delete Test Case
    public void deleteTestCase(Long id) {
        repository.deleteById(id);
    }
}