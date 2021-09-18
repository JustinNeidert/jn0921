/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.RentalDaysInvalidException;
import com.neidert.jn0921.Exception.DiscountInvalidException;
import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import com.neidert.jn0921.Exception.ToolTypeInvalidException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class represents one Checkout experienced by the Customer/Employee.  This includes the
 * ability to calculate pricing and display details of renting several tools over multiple 
 * date ranges.
 * 
 * @author Justin Neidert
 */
public class Checkout {
    /**
     * This is a list of all rental agreements processed during this Checkout.
     */
    private ArrayList<RentalAgreement> rentalAgreements;
    
    /**
     * This creates a new Checkout instance.
     * @param toolCode This is the unique code identifying the tool for this Checkout's first rental agreement.
     * @param rentalDays This is the number of days this Checkout's first tool is to be rented.
     * @param discountPercent This is the percent discount to be applied to the first rental agreement price.
     * @param dateCheckout This is the date that this Checkout's first tool is being checked out.
     * @throws RentalDaysInvalidException
     * @throws DiscountInvalidException 
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException 
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException 
     */
    public Checkout(String toolCode, int rentalDays, int discountPercent, LocalDate dateCheckout) throws RentalDaysInvalidException, DiscountInvalidException, ToolCodeInvalidException, ToolTypeInvalidException {
        setRentalAgreements(new ArrayList<>());
                
        addRental(toolCode, rentalDays, discountPercent, dateCheckout);	
    }
    
    /**
     * This function will add a new rental agreement to this Checkout, if the agreement is valid.
     * @param toolCode This is the unique code identifying a tool.
     * @param rentalDays This is the number of days the tool is to be rented.  Must be greater than 0.
     * @param discountPercent This is the percent discount to be applied to the price.  Must be
     *                        in the range [0-100].
     * @param dateCheckOut This is the date that the tool is being checked out.
     * @throws RentalDaysInvalidException Thrown if rental days aren't greater than 0.
     * @throws DiscountInvalidException Thrown if discount percent is not a number in [0-100].
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    public final void addRental(String toolCode, int rentalDays, int discountPercent, LocalDate dateCheckOut) throws RentalDaysInvalidException, DiscountInvalidException, ToolCodeInvalidException, ToolTypeInvalidException {
        //Check if number of rental days is valid
        if(!rentalDaysIsValid(rentalDays)) {
            throw new RentalDaysInvalidException("Number of rental days must be greater than 0.");
        }
        
        //Check if discount percent is valid
        if(!discountIsValid(discountPercent)) {
            throw new DiscountInvalidException("Discount percent must be in the range [0-100].");
        }
        
        //Add first new rentail agreement
        getRentalAgreements().add(new RentalAgreement(toolCode, rentalDays, discountPercent, dateCheckOut, getRentalCount() + 1));
    }
    
    /**
     * This function creates a string with details about every rental agreement in this Checkout.
     * @return This returns a string with details about every rental agreement in this Checkout.
     */
    public String detailString() {
        String toStr = "";
        for(RentalAgreement rental : rentalAgreements)
        {
            toStr += "Rental " + rental.getIndex() + ":\n" + rental.detailString() + "\n";
        }
        return toStr;
    }
    
    /**
     * This function prints the details of all rental agreements to the Console.
     */
    public void printFullDetails()
    {
        System.out.println(detailString());
    }
    
    /**
     * This function will check if rentalDays is valid by checking that it is greater than 0.
     * @param rentalDays This is the number of days to rent a tool.  Must be greater than 0.
     * @return This returns true if rentalDays is greater than 0, and false otherwise.
     */
    private boolean rentalDaysIsValid(int rentalDays) {
        return rentalDays > 0;
    }
    
    /**
     * This function will check if discountPercent is valid by checking if it is in the range [0-100].
     * @param discountPercent The discount percent applied to the rental agreement price.  
     *                        Must be in the range [0-100].
     * @return This returns true if discountPercent is in the range [0-100], and false otherwise.
     */
    private boolean discountIsValid(int discountPercent) {
        return discountPercent >= 0 && discountPercent <= 100;
    }	
    
    /**
     * This function returns the number of rental agreements currently managed by this Checkout.
     * @return This is the number of rental agreements currently managed by this Checkout.
     */
    private int getRentalCount() {
        return getRentalAgreements().size();
    }
    
    /**
     * This gets the list of rental agreements.
     * @return This is the list of rental agreements.
     */
    private ArrayList<RentalAgreement> getRentalAgreements() { return rentalAgreements; }
    
    /**
     * This sets the list of rental agreements.
     * @param agreements This is the list of rental agreements to assign to.
     */
    private void setRentalAgreements(ArrayList<RentalAgreement> agreements) { rentalAgreements = agreements; }
}
