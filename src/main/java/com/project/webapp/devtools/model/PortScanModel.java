/**
 * 
 */
package com.project.webapp.devtools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */
public class PortScanModel {
	

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	@JsonProperty
	public String message = null;
	
	@JsonProperty
	public Integer port = null;

	@JsonProperty
	public String host = null;
	
	@JsonProperty
	public Boolean isOpen = null;

	/**
	 * @return the isOpen
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}
