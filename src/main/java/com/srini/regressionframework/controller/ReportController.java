package com.srini.regressionframework.controller;

import com.srini.regressionframework.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/summary")
    public Map<String, Object> getSummary() {
        return reportService.getDetails();
    }
}