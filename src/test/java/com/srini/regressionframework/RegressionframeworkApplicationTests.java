package com.srini.regressionframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling; // ✅ ADD THIS

@SpringBootApplication
@EnableScheduling   // ✅ ADD HERE (VERY IMPORTANT)
public class RegressionframeworkApplicationTests{
    public static void main(String[] args) {
        SpringApplication.run(RegressionframeworkApplication.class, args);
    }
}