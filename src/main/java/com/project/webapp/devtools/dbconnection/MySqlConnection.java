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
public class MySqlConnection {

	
	@RequestMapping(value="mysql/testConnection", method=RequestMethod.GET)
	public Boolean oracleDatabaseConnection( @RequestBody DatabaseConnectionModel mysqlDatabase){

        try {
            Class.forName(ConstantValues.MYSQL_JDBC_CLASSLOADER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;

        }

        Connection connection = null;
        String URL = mysqlUrlBuilder(mysqlDatabase);
        
        try {

            connection = DriverManager.getConnection(
                    URL, mysqlDatabase.getUserName(), mysqlDatabase.getPassword());

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
	
	// Fix the MySql Url Builder
	public String mysqlUrlBuilder(DatabaseConnectionModel mysqlDatabase){
    	final String url = ConstantValues.ORACLE_JDBC+ConstantValues.COLON+ConstantValues.ORACLE+ConstantValues.COLON+
    			ConstantValues.ORACLE_JDBC_THIN+ConstantValues.COLON+ConstantValues.AT+mysqlDatabase.getHostName()+
    			ConstantValues.COLON+mysqlDatabase.getPortNumber()+ConstantValues.COLON+mysqlDatabase.getDataSourcename();
    	return url;
    }
	
}
