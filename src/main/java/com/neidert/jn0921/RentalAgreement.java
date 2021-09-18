/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Calendar.CalendarUtility;
import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import com.neidert.jn0921.Exception.ToolTypeInvalidException;
import java.time.LocalDate;

/**
 * Each instance of this class represents a single instance of a rented tool, including the tool's
 * descriptive details, details of the tool's charge behavior, and terms of the rental like active
 * and chargeable dates, intermediate and final pricing, and applied discounts.
 * 
 * @author Justin Neidert
 */
public class RentalAgreement {

    /**
     * The unique identifying code of the tool to be rented.
     */
    private String toolCode; 

    /**
     * The type of tool to be rented.
     */
    private String toolType;

    /**
     * The brand of the tool to be rented.
     */
    private String toolBrand;

    /**
     * The number of days the tool will be rented.
     */
    private int rentalDayCount; 

    /**
     * The date the tool will be checked out.
     */
    private LocalDate checkoutDate; 

    /**
     * The date the tool will be due to be checked back in.
     */
    private LocalDate dueDate;

    /**
     * The daily cost to rent the tool in cents.
     */
    private int dailyRentalChargeCents;

    /**
     * The number of rental days that will charge money.
     */
    private int chargeDays;

    /**
     * The cost of the rental before the discount is applied.
     */
    private int preDiscountChargeCents;

    /**
     * The discount to be applied in percent.
     */
    private int discountPercent; 

    /**
     * The discount to be applied in cents.
     */
    private int discountAmountCents;

    /**
     * The final cost of the rental after the discount has been applied.
     */
    private int finalChargeCents;

    /**
     * Number representing which of a Checkout's rental agreements this is.
     */
    private int index;

    /**
     * An instance of the tool to be rented.
     */
    private Tool tool;

    /**
     * The format of date Strings.
     */    
    private String dateFormat = "MM/dd/YYYY";

    /**
     * This creates a new rental agreement, using details about the tool and rental terms to
     * populate other important details like cost.
     * @param tool The unique identifying code of the tool to be rented.
     * @param rentalDays The number of days the tool will be rented.
     * @param discount The discount to be applied in percent.
     * @param dateCheckOut The date the tool will be checked out.
     * @param rentalIndex Number representing which of a Checkout's rental agreements this is.
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    public RentalAgreement(String tool, int rentalDays, int discount, LocalDate dateCheckOut, int rentalIndex) throws ToolCodeInvalidException, ToolTypeInvalidException {
        setToolCode(tool);
        setRentalDayCount(rentalDays);
        setDiscountPercent(discount);
        setCheckoutDate(dateCheckOut);
        setIndex(rentalIndex);
        
        initializeDetails();		
    }
    
    /**
     * This function uses the existing tool code, rental days, discount percent, and checkout date
     * to populate the rest of the details needed by the rental agreement.
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    private void initializeDetails() throws ToolCodeInvalidException, ToolTypeInvalidException {
        setTool(DatabaseAccessor.getToolWithCharge(getToolCode()));
        setToolType(getTool().getToolType());
        setToolBrand(getTool().getToolBrand());
        setDueDate(getCheckoutDate().plusDays(getRentalDayCount()));
        setDailyRentalChargeCents(getTool().getDailyChargeCents());
        setChargeDays(calculateChargeDays());
        setPreDiscountChargeCents(calculatePreDiscountCents());
        setDiscountAmountCents(calculateDiscountCents());
        setFinalChargeCents(calculateFinalChargeCents());
    }    
    
    /**
     * This function creates a string with details about this rental agreement.
     * @return This returns a string with details about this rental agreement. 
     */
    public String detailString() {
        String toStr = "Tool code: " + getToolCode() +
                "\nTool type: " + getToolType() + 
                "\nTool brand: " + getToolBrand() +
                "\nRental days: " + getRentalDayCount() +
                "\nCheckout date: " + getCheckoutDateStr() + 
                "\nDue date: " + getDueDateStr() +
                "\nDaily rental charge: " + getDailyRentalChargeStr() +
                "\nCharge days: " + getChargeDays() +
                "\nPre-discount charge: " + getPreDiscountStr() +
                "\nDiscount percent: " + getDiscountPercentStr() +
                "\nDiscount amount: " + getDiscountCurrencyStr() +
                "\nFinal charge: " + getFinalChargeStr();
        return toStr;
    }
    
    /**
     * This function prints the details of this rental agreement to the Console.
     */
    public void printFullDetails() {
        System.out.println(detailString());
    }
    
    /**
     * Calculates the number of days in the rental period that can be charged for.
     * @return Returns the number of days in the rental period that can be charged for.
     */
    private int calculateChargeDays() {
        int days = CalendarUtility.daysInRange(getCheckoutDate().plusDays(1), getDueDate());
        if(!tool.isHolidayCharge())
            days -= CalendarUtility.countHolidaysInRange(getCheckoutDate().plusDays(1), getDueDate());
        if(!tool.isWeekendCharge())
            days -= CalendarUtility.countWeekendDaysInRange(getCheckoutDate().plusDays(1), getDueDate());
        if(!tool.isWeekdayCharge())
            days -= CalendarUtility.countWeekdaysInRange(getCheckoutDate().plusDays(1), getDueDate());
        if(days < 0)
            days = 0;
        return days;
    }
    
    /**
     * Calculates the cost of the rental before the discount is applied.
     * @return Returns the cost of the rental before the discount is applied.
     */
    private int calculatePreDiscountCents() {
        return getChargeDays() * getDailyRentalChargeCents();
    }
    
    /**
     * Calculates the discount to be applied in cents.
     * @return Returns the discount to be applied in cents.
     */
    private int calculateDiscountCents() {
        return (int)Math.round(((double)getPreDiscountChargeCents()) * ((double)getDiscountPercent()) / 100.0d);
    }
    
    /**
     * Calculates the final cost of the rental after the discount has been applied.
     * @return Returns the final cost of the rental after the discount has been applied.
     */
    private int calculateFinalChargeCents() {
        return getPreDiscountChargeCents() - getDiscountAmountCents();
    }
    
    /**
     * Gets a formatted string representing the checkout date.
     * @return Returns a formatted string representing the checkout date.
     */
    private String getCheckoutDateStr() {
        return StringFormatter.dateToString(getCheckoutDate(), getDateFormat());
    }
    
    /**
     * Gets a formatted string representing the due date.
     * @return Returns a formatted string representing the due date.
     */
    private String getDueDateStr() {
        return StringFormatter.dateToString(getDueDate(), getDateFormat());
    }
    
    /**
     * Gets a string representing the daily rental charge in format "$99,999.99".
     * @return Returns a string representing the daily rental charge in format "$99,999.99".
     */
    private String getDailyRentalChargeStr() {
        return StringFormatter.centsToCurrencyString(getDailyRentalChargeCents());
    }
    
    /**
     * Gets a string in format "$99,999.99" representing the cost before a discount is applied.
     * @return Returns a string in format "$99,999.99" representing the cost before a discount is applied.
     */
    private String getPreDiscountStr() {
        return StringFormatter.centsToCurrencyString(getPreDiscountChargeCents());
    }
    
    /**
     * Gets a string in format "$99,999.99" representing the final cost of the rental.
     * @return Returns a string in format "$99,999.99" representing the final cost of the rental.
     */
    private String getFinalChargeStr() {
        return StringFormatter.centsToCurrencyString(getFinalChargeCents());
    }
    
    /**
     * Gets a formatted string containing the discount percent. 
     * @return Returns a formatted string containing the discount percent. 
     */
    private String getDiscountPercentStr() {
        return StringFormatter.percentToString(getDiscountPercent());
    }
    
    /**
     * Gets a string in format "$99,999.99" representing the entire discount amount.
     * @return Returns a string in format "$99,999.99" representing the entire discount amount.
     */
    private String getDiscountCurrencyStr() {
        return StringFormatter.centsToCurrencyString(getDiscountAmountCents());
    }
    
    /**
     * Gets the unique identifying code of the tool to be rented.
     * @return Returns the unique identifying code of the tool to be rented.
     */
    private String getToolCode() { return toolCode; }
    
    /**
     * Gets the type of tool to be rented.
     * @return Returns the type of tool to be rented.
     */
    private String getToolType() { return toolType; }
    
    /**
     * Gets the brand of the tool to be rented.
     * @return Returns the brand of the tool to be rented.
     */
    private String getToolBrand() { return toolBrand; }
    
    /**
     * Gets the number of days the tool will be rented.
     * @return Returns the number of days the tool will be rented.
     */
    private int getRentalDayCount() { return rentalDayCount; } 
    
    /**
     * Gets the date the tool will be checked out.
     * @return Returns the date the tool will be checked out.
     */
    private LocalDate getCheckoutDate() { return checkoutDate; }
    
    /**
     * Gets the date the tool will be due to be checked back in.
     * @return Returns the date the tool will be due to be checked back in.
     */
    private LocalDate getDueDate() { return dueDate; }
    
    /**
     * Gets the daily cost to rent the tool in cents.
     * @return Returns the daily cost to rent the tool in cents.
     */
    private int getDailyRentalChargeCents() { return dailyRentalChargeCents; }
    
    /**
     * Gets the number of rental days that will charge money.
     * @return Returns the number of rental days that will charge money.
     */
    private int getChargeDays() { return chargeDays; }
    
    /**
     * Gets the cost of the rental before the discount is applied.
     * @return Returns the cost of the rental before the discount is applied.
     */
    private int getPreDiscountChargeCents() { return preDiscountChargeCents; }
    
    /**
     * Gets the discount to be applied in percent.
     * @return Returns the discount to be applied in percent.
     */
    private int getDiscountPercent() { return discountPercent; }
    
    /**
     * Gets the discount to be applied in cents.
     * @return Returns the discount to be applied in cents.
     */
    private int getDiscountAmountCents() { return discountAmountCents; }
    
    /**
     * Gets the final cost of the rental after the discount has been applied.
     * @return Returns the final cost of the rental after the discount has been applied.
     */
    private int getFinalChargeCents() { return finalChargeCents; }
    
    /**
     * Gets a number representing which of a Checkout's rental agreements this is.
     * @return Returns a number representing which of a Checkout's rental agreements this is.
     */
    public int getIndex() { return index; }
    
    /**
     * Gets the instance of the tool to be rented.
     * @return Returns an instance of the tool to be rented.
     */
    private Tool getTool() { return tool; }
    
    /**
     * Gets the format of date Strings.
     * @return Returns the format of date Strings.
     */
    private String getDateFormat() { return dateFormat; }
    
    /**
     * Sets the unique identifying code of the tool to be rented.
     * @param code The unique identifying code of the tool to be assigned.
     */
    private void setToolCode(String code) { toolCode = code; }
    
    /**
     * Sets the type of tool to be rented.
     * @param type The type of tool to be assigned.
     */
    private void setToolType(String type) { toolType = type; }
    
    /**
     * Sets the brand of the tool to be rented.
     * @param brand The brand of the tool to be assigned.
     */
    private void setToolBrand(String brand) { toolBrand = brand; }
    
    /**
     * Sets the number of days the tool will be rented.
     * @param count The number of days the tool will be rented to be assigned.
     */
    private void setRentalDayCount(int count) { rentalDayCount = count; } 
    
    /**
     * Sets the date the tool will be checked out.
     * @param date The date the tool will be checked out to be assigned.
     */
    private void setCheckoutDate(LocalDate date) { checkoutDate = date; }
    
    /**
     * Sets the date the tool will be due to be checked back in.
     * @param date The date the tool will be due to be checked back in to be assigned.
     */
    private void setDueDate(LocalDate date) { dueDate = date; }
    
    /**
     * Sets the daily cost to rent the tool in cents.
     * @param cents The daily cost to rent the tool in cents to be assigned.
     */
    private void setDailyRentalChargeCents(int cents) { dailyRentalChargeCents = cents; }
    
    /**
     * Sets the number of rental days that will charge money.
     * @param days The number of rental days that will charge money to be assigned.
     */
    private void setChargeDays(int days) { chargeDays = days; }
    
    /**
     * Sets the cost of the rental before the discount is applied.
     * @param cents The cost of the rental before the discount is applied to be assigned.
     */
    private void setPreDiscountChargeCents(int cents) { preDiscountChargeCents = cents; }
    
    /**
     * Sets the discount to be applied in percent.
     * @param cents The discount in percent to be assigned.
     */
    private void setDiscountPercent(int cents) { discountPercent = cents; }
    
    /**
     * Sets the discount to be applied in cents.
     * @param cents The discount in cents to be assigned.
     */
    private void setDiscountAmountCents(int cents) { discountAmountCents = cents; }
    
    /**
     * Sets the final cost of the rental after the discount has been applied.
     * @param cents The final cost of the rental to be assigned.
     */
    private void setFinalChargeCents(int cents) { finalChargeCents = cents; }
    
    /**
     * Sets the number representing which of a Checkout's rental agreements this is.
     * @param ind The index to be assigned.
     */
    private void setIndex(int ind) { index = ind; }
    
    /**
     * Sets the instance of the tool to be rented.
     * @param tl The instance of the tool to be assigned.
     */
    private void setTool(Tool tl) { tool = tl; }
    
    /**
     * Sets the format of date Strings.
     * @param format The format of date Strings to be assigned.
     */
    private void setDateFormat(String format) { dateFormat = format; }
}
