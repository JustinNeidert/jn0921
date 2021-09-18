/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

/**
 * This class describes a tools charging behavior, including the daily rental cost, as 
 * well as whether this tool is charged for rental on weekdays, weekends, and holidays.
 * 
 * @author Justin Neidert
 */
public class ToolCharge {
    
    /**
     * This is the type of tool
     */
    private String toolType;
    
    /**
     * This is the daily cost in cents to rent this tool type.
     */
    private int dailyChargeCents;
    
    /**
     * This is whether this tool costs to rent on weekdays.
     */
    private boolean weekdayCharge;
    
    /**
     * This is whether this tool costs to rent on weekends.
     */
    private boolean weekendCharge;
    
    /**
     * This is whether this tool costs to rent on holidays.
     */
    private boolean holidayCharge;
    
    /**
     * This creates a new instance which described the charge behavior of a tool.
     * @param type This is the type of tool.
     * @param dailyCents This is the daily cost in cents to rent this tool type.
     * @param wkdayCharge This is whether this tool costs to rent on weekdays.
     * @param wkendCharge This is whether this tool costs to rent on weekends.
     * @param hdayCharge This is whether this tool costs to rent on holidays.
     */
    public ToolCharge(String type, int dailyCents, boolean wkdayCharge, boolean wkendCharge, boolean hdayCharge) {
        setToolType(type);
        setDailyChargeCents(dailyCents);
        setWeekdayCharge(wkdayCharge);
        setWeekendCharge(wkendCharge);
        setHolidayCharge(hdayCharge);
    }
    
    /**
     * Gets the daily rental charge as a formatted currency string.
     * @return Returns the daily charge as a formatted currency string. 
     */
    public String getDailyChargeString() { return StringFormatter.centsToCurrencyString(dailyChargeCents); }  
    
    /**
     * Gets the tool type.
     * @return Returns the tool type. 
     */
    public String getToolType() { return toolType; }    
    
    /**
     * Gets the daily rental cost in cents.
     * @return Returns the daily rental cost in cents. 
     */
    public int getDailyChargeCents() { return dailyChargeCents; }    
    
    /**
     * Checks if this tool charges for weekdays.
     * @return Returns if this tool charges for weekdays.
     */
    public boolean isWeekdayCharge() { return weekdayCharge; }    
    
    /**
     * Checks if this tool charges for weekends.
     * @return Returns if this tool charges for weekends.
     */
    public boolean isWeekendCharge() { return weekendCharge; }    
    
    /**
     * Checks if this tool charges for holidays.
     * @return Returns if this tool charges for holidays.
     */
    public boolean isHolidayCharge() { return holidayCharge; } 
    
    /**
     * Sets the tool type.
     * @param type The tool type to assign.
     */
    private void setToolType(String type) { toolType = type; }   
    
    /**
     * Sets the daily rental cost in cents.
     * @param cents The daily rental cost in cents to assign.
     */
    private void setDailyChargeCents(int cents) { dailyChargeCents = cents; }   
    
    /**
     * Sets whether this tool charges for weekdays.
     * @param charge The value to assign whether this tool charges for weekdays.
     */
    private void setWeekdayCharge(boolean charge) { weekdayCharge = charge; } 
    
    /**
     * Sets whether this tool charges for weekends.
     * @param charge The value to assign whether this tool charges for weekends.
     */
    private void setWeekendCharge(boolean charge) { weekendCharge = charge; }    
    
    /**
     * Sets whether this tool charges for holidays.
     * @param charge The value to assign whether this tool charges for holidays.
     */
    private void setHolidayCharge(boolean charge) { holidayCharge = charge; }
}
