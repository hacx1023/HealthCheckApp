package com.healthcheckapp;

import java.io.File;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {

        log("===== DevOps Health Check App =====");
        log("Start Time: " + LocalDateTime.now());

        boolean isHealthy = true;

        // Java version check
        log("Java Version: " + System.getProperty("java.version"));

        // Environment variable check
        String env = System.getenv("APP_ENV");
        if (env == null || env.isEmpty()) {
            error("APP_ENV not set");
            isHealthy = false;
        } else {
            log("APP_ENV: " + env);
        }

        // Config file check
        File config = new File("config.txt");
        if (!config.exists()) {
            error("config.txt not found");
            isHealthy = false;
        } else {
            log("config.txt found");
        }

        // Memory check
        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        log("Free Memory: " + freeMemory + " MB");

        if (freeMemory < 100) {
            error("Low memory");
            isHealthy = false;
        }

        // Final status
        log("-----------------------------");
        if (isHealthy) {
            log("SYSTEM STATUS: HEALTHY ✅");
            System.exit(0);
        } else {
            error("SYSTEM STATUS: UNHEALTHY ❌");
            System.exit(1);
        }
    }

    private static void log(String msg) {
        System.out.println("[INFO ] " + msg);
    }

    private static void error(String msg) {
        System.err.println("[ERROR] " + msg);
    }
}
