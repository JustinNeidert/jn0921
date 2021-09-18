/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

/**
 * This class represents one tool that is available for rent.
 * 
 * @author Justin Neidert
 */
public class Tool {
    
    /**
     * This is the unique code identifying the tool.
     */
    private String toolCode;
    
    /**
     * This is the type of tool.
     */
    private String toolType;
    
    /**
     * This is the brand of the tool.
     */
    private String toolBrand;
    
    /**
     * This defines the tool's charge properties, such as whether to charge on weekdays, weekends, 
     * and holidays, as well as a daily rental rate.
     */
    private ToolCharge charge;
    
    /**
     * This creates a new instance of the tool to be rented.
     * @param code This is the unique code identifying the tool.
     * @param type This is the type of tool.
     * @param brand This is the brand of the tool.
     */
    public Tool(String code, String type, String brand) {
        setToolCode(code);
        setToolType(type);
        setToolBrand(brand);
    }
    
    /**
     * Gets the tool code.
     * @return Returns the tool code.
     */
    private String getToolCode() { return toolCode; }

    /**
     * Gets the tool type.
     * @return Returns the tool type.
     */    
    public String getToolType() { return toolType; } 
    
    /**
     * Gets the tool brand.
     * @return Returns the tool brand. 
     */
    public String getToolBrand() { return toolBrand; } 
    
    /**
     * Gets the tool charge object.
     * @return Returns the tool charge object.
     */
    public ToolCharge getCharge() { return charge; }    
    
    /**
     * Sets the tool code.
     * @param code The tool code to assign.
     */
    private void setToolCode(String code) { toolCode = code; }

    /**
     * Sets the tool type.
     * @param type The tool type to assign.
     */
    private void setToolType(String type) { toolType = type; }    
    
    /**
     * Sets the tool brand.
     * @param brand The tool brand to assign.
     */
    private void setToolBrand(String brand) { toolBrand = brand; } 
    
    /**
     * Sets the tool charge object.
     * @param toolCharge The tool charge object to assign.
     */
    public void setCharge(ToolCharge toolCharge) { charge = toolCharge; }    
    
    /**
     * Gets the daily rental charge as a formatted currency string.
     * @return Returns the daily charge as a formatted currency string.
     */
    private String getDailyChargeString() {  return charge.getDailyChargeString(); } 
    
    /**
     * Gets the cent value of the daily rental charge.
     * @return Returns the cent value of the daily rental charge.
     */
    public int getDailyChargeCents() {  return charge.getDailyChargeCents(); } 
    
    /**
     * Checks if this tool charges for weekdays.
     * @return Returns if this tool charges for weekdays.
     */
    public boolean isWeekdayCharge() { return charge.isWeekdayCharge(); }  
    
    /**
     * Checks if this tool charges for weekends.
     * @return Returns if this tool charges for weekends.
     */
    public boolean isWeekendCharge() { return charge.isWeekendCharge(); }

    /**
     * Checks if this tool charges for holidays.
     * @return Returns if this tool charges for holidays.
     */    
    public boolean isHolidayCharge() { return charge.isHolidayCharge(); }   
}
