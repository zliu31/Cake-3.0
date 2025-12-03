package com.cake.customization.service;

import com.cake.customization.model.CakeOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class for handling cake order business logic
 * 
 * This service manages cake orders, validation, and storage
 * (using in-memory storage for simplicity)
 */
@Service
public class CakeService {

    // In-memory storage for cake orders
    private final Map<Long, CakeOrder> orderStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Valid options
    private static final String[] VALID_BASES = {"matcha", "vanilla", "red"};
    private static final String[] VALID_FROSTINGS = {"white", "pink", "brown", "purple", "yellow"};

    /**
     * Saves a new cake order
     * 
     * @param cakeOrder The cake order to save
     * @return The saved cake order with generated ID
     */
    public CakeOrder saveCakeOrder(CakeOrder cakeOrder) {
        if (cakeOrder == null) {
            throw new IllegalArgumentException("Cake order cannot be null");
        }

        if (!validateCakeOrder(cakeOrder)) {
            throw new IllegalArgumentException("Invalid cake order: missing required fields");
        }

        // Generate ID if not present
        if (cakeOrder.getId() == null) {
            cakeOrder.setId(idGenerator.getAndIncrement());
        }

        orderStorage.put(cakeOrder.getId(), cakeOrder);
        System.out.println("Saved cake order: " + cakeOrder);
        
        return cakeOrder;
    }

    /**
     * Retrieves all cake orders
     * 
     * @return List of all cake orders
     */
    public List<CakeOrder> getAllOrders() {
        return new ArrayList<>(orderStorage.values());
    }

    /**
     * Retrieves a specific cake order by ID
     * 
     * @param id The order ID
     * @return The cake order, or null if not found
     */
    public CakeOrder getOrderById(Long id) {
        return orderStorage.get(id);
    }

    /**
     * Validates a cake order
     * 
     * @param cakeOrder The cake order to validate
     * @return true if valid, false otherwise
     */
    public boolean validateCakeOrder(CakeOrder cakeOrder) {
        if (cakeOrder == null) {
            return false;
        }

        // Check if base type is valid
        boolean validBase = false;
        for (String base : VALID_BASES) {
            if (base.equalsIgnoreCase(cakeOrder.getBaseType())) {
                validBase = true;
                break;
            }
        }

        // Check if frosting type is valid
        boolean validFrosting = false;
        for (String frosting : VALID_FROSTINGS) {
            if (frosting.equalsIgnoreCase(cakeOrder.getFrostingType())) {
                validFrosting = true;
                break;
            }
        }

        return validBase && validFrosting;
    }

    /**
     * Validates if a base type is valid
     * 
     * @param baseType The base type to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidBaseType(String baseType) {
        for (String base : VALID_BASES) {
            if (base.equalsIgnoreCase(baseType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates if a frosting type is valid
     * 
     * @param frostingType The frosting type to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidFrostingType(String frostingType) {
        for (String frosting : VALID_FROSTINGS) {
            if (frosting.equalsIgnoreCase(frostingType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets all valid base types
     * 
     * @return Array of valid base types
     */
    public String[] getValidBaseTypes() {
        return VALID_BASES.clone();
    }

    /**
     * Gets all valid frosting types
     * 
     * @return Array of valid frosting types
     */
    public String[] getValidFrostingTypes() {
        return VALID_FROSTINGS.clone();
    }

    /**
     * Deletes a cake order by ID
     * 
     * @param id The order ID to delete
     * @return true if deleted, false if not found
     */
    public boolean deleteOrder(Long id) {
        return orderStorage.remove(id) != null;
    }

    /**
     * Gets the total number of orders
     * 
     * @return The total count of orders
     */
    public int getOrderCount() {
        return orderStorage.size();
    }

    /**
     * Clears all orders (useful for testing)
     */
    public void clearAllOrders() {
        orderStorage.clear();
        System.out.println("All orders cleared");
    }
}
