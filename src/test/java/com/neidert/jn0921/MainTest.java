/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.DiscountInvalidException;
import com.neidert.jn0921.Exception.RentalDaysInvalidException;
import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import java.time.DateTimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Main class.
 * 
 * @author Justin Neidert
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        
        boolean exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","9/3/15","5","101%"};
            Main.main(args);
        } catch (DiscountInvalidException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"LADW","7/2/20","3","10%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"CHNS","7/2/15","5","25%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKD","9/3/15","6","0%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","7/2/15","9","0%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","7/2/20","4","50%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","9/3/15","5","-1%"};
            Main.main(args);
        } catch (DiscountInvalidException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","9/3/15","5","100%"};
            Main.main(args);
        } catch(Exception ex) {
            exceptionCaught = true;
        }
        assertFalse(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","9/3/15","0","100%"};
            Main.main(args);
        } catch (RentalDaysInvalidException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"ABCD","9/3/15","1","100%"};
            Main.main(args);
        } catch (ToolCodeInvalidException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
        
        exceptionCaught = false;
        try {
            String[] args = new String[]{"JAKR","30/3/15","1","0%"};
            Main.main(args);
        } catch (DateTimeException ex) {
            exceptionCaught = true;
        }
        assertTrue(exceptionCaught);
    }
    
}
