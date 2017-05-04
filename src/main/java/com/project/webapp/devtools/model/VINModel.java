/**
 * 
 */
package com.project.webapp.devtools.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */
public class VINModel {
	
	@JsonProperty
	public String Count = null;
	
	@JsonProperty
	public String Message = null;
	
	/**
	 * @return the count
	 */
	public String getCount() {
		return Count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		Count = count;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * @return the searchCriteria
	 */
	public String getSearchCriteria() {
		return SearchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(String searchCriteria) {
		SearchCriteria = searchCriteria;
	}

	/**
	 * @return the results
	 */
	public ArrayList<VinResult> getResults() {
		return Results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(ArrayList<VinResult> results) {
		Results = results;
	}

	@JsonProperty
	public String SearchCriteria = null;
	
	@JsonProperty
	public ArrayList<VinResult> Results = null;

}
