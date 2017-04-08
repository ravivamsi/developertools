/**
 * 
 */
package com.project.webapp.devtools.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
public class DB2Connection {

	
	@RequestMapping(value="db2/testConnection", method=RequestMethod.GET)
	public Boolean oracleDatabaseConnection( @RequestBody DatabaseConnectionModel db2Database){

        try {
            Class.forName(ConstantValues.DB2_JDBC_CLASSLOADER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;

        }

        Connection connection = null;
        String URL = db2UrlBuilder(db2Database);
        
        try {

            connection = DriverManager.getConnection(
                    URL, db2Database.getUserName(), db2Database.getPassword());

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
	
	// Fix the DB2 Url Builder
	public String db2UrlBuilder(DatabaseConnectionModel oracleDatabase){
    	final String url = ConstantValues.ORACLE_JDBC+ConstantValues.COLON+ConstantValues.ORACLE+ConstantValues.COLON+
    			ConstantValues.ORACLE_JDBC_THIN+ConstantValues.COLON+ConstantValues.AT+oracleDatabase.getHostName()+
    			ConstantValues.COLON+oracleDatabase.getPortNumber()+ConstantValues.COLON+oracleDatabase.getDataSourcename();
    	return url;
    }

}
