/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.DiscountInvalidException;
import com.neidert.jn0921.Exception.RentalDaysInvalidException;
import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import com.neidert.jn0921.Exception.ToolTypeInvalidException;
import java.time.LocalDate;


/**
 * This is the main class.
 * 
 * @author Justin Neidert
 */
public class Main {
    public static void main(String[] args) throws RentalDaysInvalidException, DiscountInvalidException, ToolCodeInvalidException, ToolTypeInvalidException {
        if(args.length > 0 && (args.length % 4) == 0) 
        {
            //Create new checkout with the first rental agreement args
            String toolCode = args[0];
            LocalDate checkoutDate = parseDate(args[1]); 
            int rentalDays = Integer.parseInt(args[2]);
            int discountPercent = parsePercent(args[3]);
            Checkout checkout = new Checkout(toolCode, rentalDays, discountPercent, checkoutDate);
            
            //Populate the checkout with the remaining rental agreements if there are multiple
            for(int i = 4; i < args.length; i += 4)
            {
                checkout.addRental(toolCode, rentalDays, discountPercent, checkoutDate);
            }
            
            checkout.printFullDetails();
        }
    }    
    
    private static LocalDate parseDate(String dateStr) {
        int firstSlashIndex = dateStr.indexOf("/");
        int secondSlashIndex = dateStr.indexOf("/", firstSlashIndex + 1);
        String monthNum = dateStr.substring(0, firstSlashIndex);
        String dayOfMonth = dateStr.substring(firstSlashIndex + 1, secondSlashIndex);
        String year = "20" + dateStr.substring(secondSlashIndex + 1, dateStr.length());
        if(monthNum.length() == 1) 
            monthNum = "0" + monthNum;
        if(dayOfMonth.length() == 1)
            dayOfMonth = "0" + dayOfMonth;
        return LocalDate.parse(year + "-" + monthNum + "-" + dayOfMonth);
    }
    
    private static int parsePercent(String percentStr) {
        return Integer.parseInt(percentStr.substring(0, percentStr.length() - 1)); //Note: this expects arg[3] is of the form X%, XX%, XXX%, etc.
    }
}
