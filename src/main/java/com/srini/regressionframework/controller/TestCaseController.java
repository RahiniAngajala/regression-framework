package com.srini.regressionframework.controller;

import com.srini.regressionframework.entity.TestCase;
import com.srini.regressionframework.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService service;

    @PostMapping
    public TestCase addTestCase(@RequestBody TestCase testCase) {
        return service.addTestCase(testCase);
    }

    @GetMapping
    public List<TestCase> getAll() {
        return service.getAllTestCases();
    }
}