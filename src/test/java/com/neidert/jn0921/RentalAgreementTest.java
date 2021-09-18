/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the RentalAgreement class.
 * 
 * @author Justin Neidert
 */
public class RentalAgreementTest {
    
    public RentalAgreementTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of detailString method, of class RentalAgreement.
     */
    @Test
    public void testDetailString() {
        System.out.println("detailString");
        
        String toolCode = "LADW";
        int rentalDays = 3;
        int discountPercent = 10;
        LocalDate dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        try {
            RentalAgreement instance = new RentalAgreement(toolCode, rentalDays, discountPercent, dateCheckOut, 1); 
            String expResult = "Tool code: LADW\n" +
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
                               "Final charge: $5.37";
            String result = instance.detailString();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getMessage());
        }
    }

    /**
     * Test of getIndex method, of class RentalAgreement.
     */
    @Test
    public void testGetIndex() {
        System.out.println("getIndex");
        
        String toolCode = "LADW";
        int rentalDays = 3;
        int discountPercent = 10;
        LocalDate dateCheckOut = LocalDate.of(2021, Month.SEPTEMBER, 13);
        try {
            RentalAgreement instance = new RentalAgreement(toolCode, rentalDays, discountPercent, dateCheckOut, 1);        
            int expResult = 1;
            int result = instance.getIndex();
            assertEquals(expResult, result);


            instance = new RentalAgreement(toolCode, rentalDays, discountPercent, dateCheckOut, 2);        
            expResult = 2;
            result = instance.getIndex();
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail("Exception thrown: " + ex.getMessage());
        }
    }
    
}
