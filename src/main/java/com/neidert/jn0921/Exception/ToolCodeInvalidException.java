/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921.Exception;

/**
 * This class represents an exception when a tool code is used that is invalid or
 * doesn't exist.
 * 
 * @author Justin Neidert
 */
public class ToolCodeInvalidException extends Exception {
    
    /**
     * This creates a new ToolCodeInvalidException.
     * @param errorMessage This is a message describing the error inducing the exception.
     */
    public ToolCodeInvalidException(String errorMessage) {
        super(errorMessage);
    }
    
}
