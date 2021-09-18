/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Calendar.July4th;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the July4th class.
 * 
 * @author Justin Neidert
 */
public class July4thTest {
    
    public July4thTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getDate method, of class July4th.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        for(int i = 0; i < 3000; i++) {
            int year = i;
            July4th instance = new July4th();
            LocalDate expResult = LocalDate.of(i, Month.JULY, 4);
            LocalDate result = instance.getDate(year);
            assertEquals(expResult, result);
        }
    }
    
}
