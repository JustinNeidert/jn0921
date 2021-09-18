/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.RentalDaysInvalidException;
import com.neidert.jn0921.Exception.DiscountInvalidException;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Checkout class.
 * 
 * @author Justin Neidert
 */
public class CheckoutTest {
    
    public CheckoutTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of addRental method, of class Checkout.
     */
    @Test
    public void testAddRental() throws Exception {
        System.out.println("addRental");
        
        String toolCode = "LADW";
        int rentalDays = 3;
        int discountPercent = 10;
        LocalDate dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            toolCode = "CHNS";
            rentalDays = 1;
            discountPercent = 0;
            dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);            
            instance.addRental(toolCode, rentalDays, discountPercent, dateCheckOut);
            
            String expResult = "Rental 1:\n" +
                               "Tool code: LADW\n" +
                               "Tool type: Ladder\n" +
                               "Tool brand: Werner\n" +
                               "Rental days: 3\n" +
                               "Checkout date: 09/13/2021\n" +
                               "Due date: 09/16/2021\n" +
                               "Daily rental charge: $1.99\n" +
                               "Charge days: 3\n" +
                               "Pre-discount charge: $5.97\n" +
                               "Discount percent: 10%\n" +
                               "Discount amount: $0.60\n" +
                               "Final charge: $5.37\n" +
                               "Rental 2:\n" +
                               "Tool code: CHNS\n" +
                               "Tool type: Chainsaw\n" +
                               "Tool brand: Stihl\n" +
                               "Rental days: 1\n" +
                               "Checkout date: 09/13/2021\n" +
                               "Due date: 09/14/2021\n" +
                               "Daily rental charge: $1.49\n" +
                               "Charge days: 1\n" +
                               "Pre-discount charge: $1.49\n" +
                               "Discount percent: 0%\n" +
                               "Discount amount: $0.00\n" +
                               "Final charge: $1.49\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Rental days and discount were valid.  Shouldn't have had an exception.  Exception: " + ex.getMessage());
        }
        
        Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
        
        toolCode = "CHNS";
        rentalDays = 0;
        discountPercent = 0;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        boolean exCaught = false;
        try {
            instance.addRental(toolCode, rentalDays, discountPercent, dateCheckOut);
        } catch (DiscountInvalidException ex) {
            fail("Discount was valid.  Shouldn't have had an exception.  Exception: " + ex.getMessage());
        } catch (RentalDaysInvalidException ex) {
            exCaught = true;
        }        
        assertTrue(exCaught);
        
        toolCode = "JAKR";
        rentalDays = 1;
        discountPercent = 101;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        exCaught = false;
        try {
            instance.addRental(toolCode, rentalDays, discountPercent, dateCheckOut);
        } catch (DiscountInvalidException ex) {
            exCaught = true;
        } catch (RentalDaysInvalidException ex) {
            fail("Rental days was valid.  Shouldn't have had an exception.  Exception: " + ex.getMessage());
        }
        assertTrue(exCaught);
        
        toolCode = "JAKD";
        rentalDays = 1;
        discountPercent = -1;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        exCaught = false;
        try {
            instance.addRental(toolCode, rentalDays, discountPercent, dateCheckOut);
        } catch (DiscountInvalidException ex) {
            exCaught = true;
        } catch (RentalDaysInvalidException ex) {
            fail("Rental days was valid.  Shouldn't have had an exception.  Exception: " + ex.getMessage());
        }
        assertTrue(exCaught);
        
    }

    /**
     * Test of detailString method, of class Checkout.
     */
    @Test
    public void testDetailString() {
        System.out.println("detailString");
        
        String toolCode = "LADW";
        int rentalDays = 3;
        int discountPercent = 10;
        LocalDate dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            String expResult = "Rental 1:\n" +
                               "Tool code: LADW\n" +
                               "Tool type: Ladder\n" +
                               "Tool brand: Werner\n" +
                               "Rental days: 3\n" +
                               "Checkout date: 09/13/2021\n" +
                               "Due date: 09/16/2021\n" +
                               "Daily rental charge: $1.99\n" +
                               "Charge days: 3\n" +
                               "Pre-discount charge: $5.97\n" +
                               "Discount percent: 10%\n" +
                               "Discount amount: $0.60\n" +
                               "Final charge: $5.37\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
        
        toolCode = "JAKR";
        rentalDays = 6;
        discountPercent = 5;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 3);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            String expResult = "Rental 1:\n" +
                               "Tool code: JAKR\n" +
                               "Tool type: Jackhammer\n" +
                               "Tool brand: Ridgid\n" +
                               "Rental days: 6\n" +
                               "Checkout date: 09/03/2021\n" +
                               "Due date: 09/09/2021\n" +
                               "Daily rental charge: $2.99\n" +
                               "Charge days: 3\n" +
                               "Pre-discount charge: $8.97\n" +
                               "Discount percent: 5%\n" +
                               "Discount amount: $0.45\n" +
                               "Final charge: $8.52\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
        
        toolCode = "CHNS";
        rentalDays = 6;
        discountPercent = 1;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 3);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            String expResult = "Rental 1:\n" +
                               "Tool code: CHNS\n" +
                               "Tool type: Chainsaw\n" +
                               "Tool brand: Stihl\n" +
                               "Rental days: 6\n" +
                               "Checkout date: 09/03/2021\n" +
                               "Due date: 09/09/2021\n" +
                               "Daily rental charge: $1.49\n" +
                               "Charge days: 4\n" +
                               "Pre-discount charge: $5.96\n" +
                               "Discount percent: 1%\n" +
                               "Discount amount: $0.06\n" +
                               "Final charge: $5.90\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
        
        toolCode = "LADW";
        rentalDays = 6;
        discountPercent = 9;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 3);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            String expResult = "Rental 1:\n" +
                               "Tool code: LADW\n" +
                               "Tool type: Ladder\n" +
                               "Tool brand: Werner\n" +
                               "Rental days: 6\n" +
                               "Checkout date: 09/03/2021\n" +
                               "Due date: 09/09/2021\n" +
                               "Daily rental charge: $1.99\n" +
                               "Charge days: 5\n" +
                               "Pre-discount charge: $9.95\n" +
                               "Discount percent: 9%\n" +
                               "Discount amount: $0.90\n" +
                               "Final charge: $9.05\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
                
        toolCode = "LADW";
        rentalDays = 6;
        discountPercent = 9;
        dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 3);
        try {
            Checkout instance = new Checkout(toolCode, rentalDays, discountPercent, dateCheckOut);
            String expResult = "Rental 1:\n" +
                               "Tool code: LADW\n" +
                               "Tool type: Ladder\n" +
                               "Tool brand: Werner\n" +
                               "Rental days: 6\n" +
                               "Checkout date: 09/03/2021\n" +
                               "Due date: 09/09/2021\n" +
                               "Daily rental charge: $1.99\n" +
                               "Charge days: 5\n" +
                               "Pre-discount charge: $9.95\n" +
                               "Discount percent: 9%\n" +
                               "Discount amount: $0.90\n" +
                               "Final charge: $9.05\n";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception: " + ex.getMessage());
        }
    }
    
}
