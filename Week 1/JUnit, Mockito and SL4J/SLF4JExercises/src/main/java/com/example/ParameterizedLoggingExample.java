package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "Shubaashree";
        int age = 20;

        logger.info("User Name: {}", name);

        logger.info("Age: {}", age);

        logger.info("User {} is {} years old.", name, age);

    }
}