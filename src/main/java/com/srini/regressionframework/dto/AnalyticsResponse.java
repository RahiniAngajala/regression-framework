package com.srini.regressionframework.dto;

public class AnalyticsResponse {

    private long total;
    private long passed;
    private long failed;
    private double passPercentage;
    private double failPercentage;

    public AnalyticsResponse(long total, long passed, long failed) {
        this.total = total;
        this.passed = passed;
        this.failed = failed;

        if (total == 0) {
            this.passPercentage = 0;
            this.failPercentage = 0;
        } else {
            this.passPercentage = (passed * 100.0) / total;
            this.failPercentage = (failed * 100.0) / total;
        }
    }

    public long getTotal() { return total; }

    public long getPassed() { return passed; }

    public long getFailed() { return failed; }

    public double getPassPercentage() { return passPercentage; }

    public double getFailPercentage() { return failPercentage; }
}