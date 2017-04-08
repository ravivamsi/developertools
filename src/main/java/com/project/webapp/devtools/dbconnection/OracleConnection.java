/**
 * 
 */
package com.project.webapp.devtools.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.webapp.devtools.util.ConstantValues;

/**
 * @author Vamsi Ravi
 *
 */
@RestController
public class OracleConnection {
	
	@RequestMapping(value="oracle/testConnection", method=RequestMethod.GET)
	public Boolean oracleDatabaseConnection( @RequestBody DatabaseConnectionModel oracleDatabase){

        try {
            Class.forName(ConstantValues.ORACLE_JDBC_CLASSLOADER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;

        }

        Connection connection = null;
        String URL = oracleUrlBuilder(oracleDatabase);
        
        try {

            connection = DriverManager.getConnection(
                    URL, oracleDatabase.getUserName(), oracleDatabase.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        if (connection != null) {
        	try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return true;
        } else {
            return false;
        }
		
	}
	
	
	public String oracleUrlBuilder(DatabaseConnectionModel oracleDatabase){
    	final String url = ConstantValues.ORACLE_JDBC+ConstantValues.COLON+ConstantValues.ORACLE+ConstantValues.COLON+
    			ConstantValues.ORACLE_JDBC_THIN+ConstantValues.COLON+ConstantValues.AT+oracleDatabase.getHostName()+
    			ConstantValues.COLON+oracleDatabase.getPortNumber()+ConstantValues.COLON+oracleDatabase.getDataSourcename();
    	return url;
    }
	
	
}
