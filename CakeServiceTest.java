package com.cake.customization.service;

import com.cake.customization.model.CakeOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CakeService
 * 
 * Tests the business logic for cake order management
 */
@SpringBootTest
public class CakeServiceTest {

    private CakeService cakeService;

    @BeforeEach
    void setUp() {
        cakeService = new CakeService();
        cakeService.clearAllOrders();
    }

    @Test
    void testSaveCakeOrder() {
        // Create a test order
        CakeOrder order = new CakeOrder("vanilla", "pink", true);
        
        // Save the order
        CakeOrder saved = cakeService.saveCakeOrder(order);
        
        // Verify
        assertNotNull(saved.getId());
        assertEquals("vanilla", saved.getBaseType());
        assertEquals("pink", saved.getFrostingType());
        assertTrue(saved.isHasStrawberry());
    }

    @Test
    void testValidateCakeOrder_Valid() {
        CakeOrder order = new CakeOrder("matcha", "white", true);
        assertTrue(cakeService.validateCakeOrder(order));
    }

    @Test
    void testValidateCakeOrder_InvalidBase() {
        CakeOrder order = new CakeOrder("chocolate", "white", true);
        assertFalse(cakeService.validateCakeOrder(order));
    }

    @Test
    void testValidateCakeOrder_InvalidFrosting() {
        CakeOrder order = new CakeOrder("vanilla", "green", true);
        assertFalse(cakeService.validateCakeOrder(order));
    }

    @Test
    void testValidateCakeOrder_Null() {
        assertFalse(cakeService.validateCakeOrder(null));
    }

    @Test
    void testGetAllOrders() {
        // Create and save multiple orders
        CakeOrder order1 = new CakeOrder("vanilla", "pink", true);
        CakeOrder order2 = new CakeOrder("matcha", "white", true);
        
        cakeService.saveCakeOrder(order1);
        cakeService.saveCakeOrder(order2);
        
        // Verify
        assertEquals(2, cakeService.getAllOrders().size());
    }

    @Test
    void testGetOrderById() {
        // Create and save an order
        CakeOrder order = new CakeOrder("red", "brown", true);
        CakeOrder saved = cakeService.saveCakeOrder(order);
        
        // Retrieve by ID
        CakeOrder retrieved = cakeService.getOrderById(saved.getId());
        
        // Verify
        assertNotNull(retrieved);
        assertEquals(saved.getId(), retrieved.getId());
        assertEquals("red", retrieved.getBaseType());
    }

    @Test
    void testDeleteOrder() {
        // Create and save an order
        CakeOrder order = new CakeOrder("vanilla", "yellow", true);
        CakeOrder saved = cakeService.saveCakeOrder(order);
        
        // Delete the order
        boolean deleted = cakeService.deleteOrder(saved.getId());
        
        // Verify
        assertTrue(deleted);
        assertNull(cakeService.getOrderById(saved.getId()));
    }

    @Test
    void testGetOrderCount() {
        assertEquals(0, cakeService.getOrderCount());
        
        cakeService.saveCakeOrder(new CakeOrder("vanilla", "pink", true));
        assertEquals(1, cakeService.getOrderCount());
        
        cakeService.saveCakeOrder(new CakeOrder("matcha", "white", true));
        assertEquals(2, cakeService.getOrderCount());
    }

    @Test
    void testIsValidBaseType() {
        assertTrue(cakeService.isValidBaseType("vanilla"));
        assertTrue(cakeService.isValidBaseType("matcha"));
        assertTrue(cakeService.isValidBaseType("red"));
        assertFalse(cakeService.isValidBaseType("chocolate"));
    }

    @Test
    void testIsValidFrostingType() {
        assertTrue(cakeService.isValidFrostingType("white"));
        assertTrue(cakeService.isValidFrostingType("pink"));
        assertTrue(cakeService.isValidFrostingType("brown"));
        assertTrue(cakeService.isValidFrostingType("purple"));
        assertTrue(cakeService.isValidFrostingType("yellow"));
        assertFalse(cakeService.isValidFrostingType("green"));
    }

    @Test
    void testGetValidBaseTypes() {
        String[] bases = cakeService.getValidBaseTypes();
        assertEquals(3, bases.length);
    }

    @Test
    void testGetValidFrostingTypes() {
        String[] frostings = cakeService.getValidFrostingTypes();
        assertEquals(5, frostings.length);
    }

    @Test
    void testClearAllOrders() {
        // Add some orders
        cakeService.saveCakeOrder(new CakeOrder("vanilla", "pink", true));
        cakeService.saveCakeOrder(new CakeOrder("matcha", "white", true));
        
        assertEquals(2, cakeService.getOrderCount());
        
        // Clear all
        cakeService.clearAllOrders();
        
        assertEquals(0, cakeService.getOrderCount());
    }
}
