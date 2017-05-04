/**
 * 
 */
package com.project.webapp.devtools.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vamsi Ravi
 *
 */
public class VinResult {

	@JsonProperty
	public String ErrorCode = null;
	
	@JsonProperty
	public String Make = null;
	
	@JsonProperty
	public String Model = null;
	
	@JsonProperty
	public String ModelYear = null;
	
	@JsonProperty
	public String FuelTypePrimary = null;
	
	@JsonProperty
	public String PlantCity = null;
	
	@JsonProperty
	public String PlantCompanyName = null;
	
	@JsonProperty
	public String PlantCountry = null;
	
	@JsonProperty
	public String PlantState = null;
		
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return ErrorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return Make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		Make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return Model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		Model = model;
	}

	/**
	 * @return the modelYear
	 */
	public String getModelYear() {
		return ModelYear;
	}

	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(String modelYear) {
		ModelYear = modelYear;
	}

	/**
	 * @return the fuelTypePrimary
	 */
	public String getFuelTypePrimary() {
		return FuelTypePrimary;
	}

	/**
	 * @param fuelTypePrimary the fuelTypePrimary to set
	 */
	public void setFuelTypePrimary(String fuelTypePrimary) {
		FuelTypePrimary = fuelTypePrimary;
	}

	/**
	 * @return the plantCity
	 */
	public String getPlantCity() {
		return PlantCity;
	}

	/**
	 * @param plantCity the plantCity to set
	 */
	public void setPlantCity(String plantCity) {
		PlantCity = plantCity;
	}

	/**
	 * @return the plantCompanyName
	 */
	public String getPlantCompanyName() {
		return PlantCompanyName;
	}

	/**
	 * @param plantCompanyName the plantCompanyName to set
	 */
	public void setPlantCompanyName(String plantCompanyName) {
		PlantCompanyName = plantCompanyName;
	}

	/**
	 * @return the plantCountry
	 */
	public String getPlantCountry() {
		return PlantCountry;
	}

	/**
	 * @param plantCountry the plantCountry to set
	 */
	public void setPlantCountry(String plantCountry) {
		PlantCountry = plantCountry;
	}

	/**
	 * @return the plantState
	 */
	public String getPlantState() {
		return PlantState;
	}

	/**
	 * @param plantState the plantState to set
	 */
	public void setPlantState(String plantState) {
		PlantState = plantState;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return Manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	/**
	 * @return the bodyClass
	 */
	public String getBodyClass() {
		return BodyClass;
	}

	/**
	 * @param bodyClass the bodyClass to set
	 */
	public void setBodyClass(String bodyClass) {
		BodyClass = bodyClass;
	}

	/**
	 * @return the displacementCC
	 */
	public String getDisplacementCC() {
		return DisplacementCC;
	}

	/**
	 * @param displacementCC the displacementCC to set
	 */
	public void setDisplacementCC(String displacementCC) {
		DisplacementCC = displacementCC;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return VehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}

	/**
	 * @return the vIN
	 */
	public String getVIN() {
		return VIN;
	}

	/**
	 * @param vIN the vIN to set
	 */
	public void setVIN(String vIN) {
		VIN = vIN;
	}

	@JsonProperty
	public String Manufacturer = null;
	
	@JsonProperty
	public String BodyClass = null;
	
	@JsonProperty
	public String DisplacementCC = null;
	
	@JsonProperty
	public String VehicleType = null;
	
	@JsonProperty
	public String VIN = null;

}
