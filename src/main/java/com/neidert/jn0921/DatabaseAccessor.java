/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neidert.jn0921;

import com.neidert.jn0921.Exception.ToolCodeInvalidException;
import com.neidert.jn0921.Exception.ToolTypeInvalidException;

  /**********************/
 /***If using MyBatis***/   
/**********************/
/*import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;*/

/**
 * This class holds all functions for interfacing with the database, as well as functions which
 * will act as a database, in lieu of an actual database connection.  Note: sections labeled 
 * "If using MyBatis" will need to be uncommented to test with an actual database connection.
 * 
 * @author Justin Neidert
 */
public class DatabaseAccessor { 
      /**********************/
     /***If using MyBatis***/   
    /**********************/    
    /**
     * This is the session factory that will create sessions for the lifetime of the application.
     */
    //private static SqlSessionFactory sqlSessionFactory;
    
    /**
     * This is the location of the config file for setting up the database mapper.
     */
    //private final static String configFile = "config.xml";

    /**
     * This will initialize the session factory from the configuration file.
     * @throws IOException
     */
    /*static public void initialize() throws IOException {
        Reader reader = Resources.getResourceAsReader(configFile);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);        
    }	
    */
    
    /**
     * This function will fetch the Tool associated with the provided unique toolCode.This function will also fetch the ToolCharge associated with this tool and
 populate this Tool's ToolCharge field with the fetched ToolCharge.
     * @param toolCode This is the unique identifier for the tool.
     * @return This returns the Tool identified by toolCode, with its ToolCharge assigned.
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    static public Tool getToolWithCharge(String toolCode) throws ToolCodeInvalidException, ToolTypeInvalidException {    
          /**********************/
         /***If using MyBatis***/   
        /**********************/
        /* 
        SqlSession session = sqlSessionFactory.openSession();      

        Tool tool = (Tool) session.selectOne("Tool.getByToolCode", toolCode); 
        ToolCharge toolCharge = session.selectOne("ToolCharge.getByType", tool.getToolType()); 
        tool.setCharge(toolCharge);
      
        session.commit();
        session.close();
        
        return tool;
        */
        
          /**************************/
         /***Done without MyBatis***/   
        /**************************/
        Tool tool = getTool(toolCode);
        ToolCharge toolCharge = getToolCharge(tool.getToolType());
        tool.setCharge(toolCharge);
        
        return tool;
    }
    
    /**
     * This function will fetch the Tool associated with the provided unique toolCode.Its ToolCharge will not be assigned.
     * @param toolCode This is the unique identifier for the tool.
     * @return This returns the Tool identified by toolCode, with no ToolCharge assigned.
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     */
    static public Tool getTool(String toolCode) throws ToolCodeInvalidException {
          /**********************/
         /***If using MyBatis***/   
        /**********************/
        /* 
        SqlSession session = sqlSessionFactory.openSession();      

        Tool tool = (Tool) session.selectOne("Tool.getByToolCode", toolCode); 
      
        session.commit();
        session.close();
        
        return tool;
        */
        
          /**************************/
         /***Done without MyBatis***/   
        /**************************/
        Tool tool = getToolNoDB(toolCode);
        return tool;
    }
    
    /**
     * This function will fetch the ToolCharge associated with the provided unique toolType.
     * @param toolType This is the unique type used to identify a ToolCharge.
     * @return This returns the ToolCharge identified by toolType.
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    static public ToolCharge getToolCharge(String toolType) throws ToolTypeInvalidException {
          /**********************/
         /***If using MyBatis***/   
        /**********************/
        /* 
        SqlSession session = sqlSessionFactory.openSession();      
        ToolCharge toolCharge = session.selectOne("ToolCharge.getByType", toolType); 
      
        session.commit();
        session.close();
        
        return toolCharge;
        */
        
          /**************************/
         /***Done without MyBatis***/   
        /**************************/
        ToolCharge toolCharge = getToolChargeNoDB(toolType);
        return toolCharge;
    }
    
    /**
     * This function will get the Tool associated with the provided unique toolCode.
     * Its ToolCharge will not be assigned.
     * This function is only for use when a database is not available.
     * @param toolCode This is the unique identifier for the tool.
     * @return This returns the Tool identified by toolCode, with no ToolCharge assigned.
     * @throws com.neidert.jn0921.Exception.ToolCodeInvalidException
     */
    static private Tool getToolNoDB(String toolCode) throws ToolCodeInvalidException {
        Tool tool;
        switch (toolCode) {
            case "LADW":
                tool = new Tool(toolCode, "Ladder", "Werner");
                break;
            case "CHNS":
                tool = new Tool(toolCode, "Chainsaw", "Stihl");
                break;
            case "JAKR":
                tool = new Tool(toolCode, "Jackhammer", "Ridgid");
                break;
            case "JAKD":
                tool = new Tool(toolCode, "Jackhammer", "DeWalt");
                break;
            default :
                throw new ToolCodeInvalidException("Tool code doesn't exist.");
        }
        return tool;
    }

    /**
     * This function will fetch the ToolCharge associated with the provided unique toolType.
     * This function is only for use when a database is not available.
     * @param toolType This is the unique type used to identify a ToolCharge.
     * @return This returns the ToolCharge identified by toolType.
     * @throws com.neidert.jn0921.Exception.ToolTypeInvalidException
     */
    static private ToolCharge getToolChargeNoDB(String toolType) throws ToolTypeInvalidException {
        ToolCharge toolCharge;
        switch (toolType) {
            case "Ladder":
                toolCharge = new ToolCharge(toolType, 199, true, true, false);
                break;
            case "Chainsaw":
                toolCharge = new ToolCharge(toolType, 149, true, false, true);
                break;
            case "Jackhammer":
                toolCharge = new ToolCharge(toolType, 299, true, false, false);
                break;
            default :
                throw new ToolTypeInvalidException("Tool type doesn't exist.");
        }
        return toolCharge;
    }
}
