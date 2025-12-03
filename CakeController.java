package com.cake.customization.controller;

import com.cake.customization.model.CakeOrder;
import com.cake.customization.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling cake customization requests
 * 
 * This controller manages the web interface and API endpoints
 * for the cake customization application.
 */
@Controller
public class CakeController {

    @Autowired
    private CakeService cakeService;

    /**
     * Serves the main cake customization interface
     * 
     * @param model Spring MVC model
     * @return View name
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Cake Customization");
        return "index";
    }

    /**
     * API endpoint to save a cake order
     * 
     * @param cakeOrder The cake order details
     * @return Saved cake order
     */
    @PostMapping("/api/cake/save")
    @ResponseBody
    public CakeOrder saveCakeOrder(@RequestBody CakeOrder cakeOrder) {
        return cakeService.saveCakeOrder(cakeOrder);
    }

    /**
     * API endpoint to retrieve all cake orders
     * 
     * @return List of all cake orders
     */
    @GetMapping("/api/cake/orders")
    @ResponseBody
    public List<CakeOrder> getAllOrders() {
        return cakeService.getAllOrders();
    }

    /**
     * API endpoint to get a specific cake order by ID
     * 
     * @param id The order ID
     * @return The cake order
     */
    @GetMapping("/api/cake/order/{id}")
    @ResponseBody
    public CakeOrder getOrderById(@PathVariable Long id) {
        return cakeService.getOrderById(id);
    }

    /**
     * API endpoint to validate cake customization choices
     * 
     * @param cakeOrder The cake order to validate
     * @return Validation result
     */
    @PostMapping("/api/cake/validate")
    @ResponseBody
    public ValidationResult validateOrder(@RequestBody CakeOrder cakeOrder) {
        boolean isValid = cakeService.validateCakeOrder(cakeOrder);
        return new ValidationResult(isValid, 
            isValid ? "Order is valid!" : "Please complete all selections");
    }

    /**
     * Inner class for validation results
     */
    public static class ValidationResult {
        private boolean valid;
        private String message;

        public ValidationResult(boolean valid, String message) {
            this.valid = valid;
            this.message = message;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
