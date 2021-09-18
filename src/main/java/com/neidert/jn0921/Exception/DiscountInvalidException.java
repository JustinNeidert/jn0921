/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Exception;

/**
 * This class represents the exception thrown when an invalid discount percent is provided.
 * 
 * @author Justin Neidert
 */
public class DiscountInvalidException extends Exception {
    
    /**
     * This creates a new DiscountInvalidException.
     * @param errorMessage This is a message describing the error inducing the exception.
     */
    public DiscountInvalidException(String errorMessage) {
        super(errorMessage);
    }
    
}
