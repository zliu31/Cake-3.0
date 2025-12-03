package com.cake.customization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application for Cake Customization
 * 
 * This application provides an interactive web interface for customizing cakes
 * with different base flavors, frosting colors, and toppings.
 * 
 * @author Cake Customization Team
 * @version 1.0
 */
@SpringBootApplication
public class CakeCustomizationApplication {

    /**
     * Main entry point for the Spring Boot application
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CakeCustomizationApplication.class, args);
        System.out.println("==============================================");
        System.out.println("Cake Customization Application Started!");
        System.out.println("Access the application at: http://localhost:8080");
        System.out.println("==============================================");
    }
}
