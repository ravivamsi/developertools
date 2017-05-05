/**
 * 
 */
package com.project.webapp.devtools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */
public class AbbrevationModel {
	
	
	@JsonProperty
	public String fullform = null;
	
	@JsonProperty
	public String meaning = null;

	/**
	 * @return the fullform
	 */
	public String getFullform() {
		return fullform;
	}

	/**
	 * @param fullform the fullform to set
	 */
	public void setFullform(String fullform) {
		this.fullform = fullform;
	}

	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * @param meaning the meaning to set
	 */
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	

}
