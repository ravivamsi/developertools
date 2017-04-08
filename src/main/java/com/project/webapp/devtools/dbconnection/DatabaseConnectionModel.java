/**
 * 
 */
package com.project.webapp.devtools.dbconnection;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */

public class DatabaseConnectionModel {

	@JsonProperty
	public String hostName = null;
	
	@JsonProperty
	public String userName = null;
	
	@JsonProperty
	public String password = null;
	
	@JsonProperty
	public String portNumber = null;
	
	@JsonProperty
	public String databaseName = null;
	
	@JsonProperty
	public String dataSourcename = null;
	
	@JsonProperty
	public String networkProtocol = null;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDataSourcename() {
		return dataSourcename;
	}

	public void setDataSourcename(String dataSourcename) {
		this.dataSourcename = dataSourcename;
	}

	public String getNetworkProtocol() {
		return networkProtocol;
	}

	public void setNetworkProtocol(String networkProtocol) {
		this.networkProtocol = networkProtocol;
	}
	
	
}
