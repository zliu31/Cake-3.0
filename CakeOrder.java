package com.cake.customization.model;

import java.time.LocalDateTime;

/**
 * Model class representing a cake order
 * 
 * This class encapsulates all the customization options
 * selected by the user for their cake.
 */
public class CakeOrder {

    private Long id;
    private String baseType;
    private String frostingType;
    private boolean hasStrawberry;
    private LocalDateTime orderTime;
    private String customerName;
    private String customerEmail;

    /**
     * Default constructor
     */
    public CakeOrder() {
        this.orderTime = LocalDateTime.now();
        this.hasStrawberry = true; // Default includes strawberry
    }

    /**
     * Parameterized constructor
     * 
     * @param baseType The base flavor (matcha, vanilla, or red)
     * @param frostingType The frosting color (white, pink, brown, purple, yellow)
     * @param hasStrawberry Whether the cake has a strawberry topping
     */
    public CakeOrder(String baseType, String frostingType, boolean hasStrawberry) {
        this();
        this.baseType = baseType;
        this.frostingType = frostingType;
        this.hasStrawberry = hasStrawberry;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getFrostingType() {
        return frostingType;
    }

    public void setFrostingType(String frostingType) {
        this.frostingType = frostingType;
    }

    public boolean isHasStrawberry() {
        return hasStrawberry;
    }

    public void setHasStrawberry(boolean hasStrawberry) {
        this.hasStrawberry = hasStrawberry;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Validates if all required fields are populated
     * 
     * @return true if the order is valid, false otherwise
     */
    public boolean isValid() {
        return baseType != null && !baseType.isEmpty() &&
               frostingType != null && !frostingType.isEmpty();
    }

    /**
     * Returns a formatted string representation of the cake order
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return String.format("CakeOrder[id=%d, base=%s, frosting=%s, strawberry=%b, time=%s]",
                id, baseType, frostingType, hasStrawberry, orderTime);
    }

    /**
     * Gets a human-readable description of the cake
     * 
     * @return Description string
     */
    public String getDescription() {
        StringBuilder desc = new StringBuilder();
        desc.append("A delicious ");
        desc.append(baseType).append(" cake");
        desc.append(" with ").append(frostingType).append(" frosting");
        if (hasStrawberry) {
            desc.append(" topped with a fresh strawberry");
        }
        return desc.toString();
    }
}
