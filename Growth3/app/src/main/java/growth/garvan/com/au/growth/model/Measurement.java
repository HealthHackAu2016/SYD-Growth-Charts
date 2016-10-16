package growth.garvan.com.au.growth.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the measurements database table.
 * 
 */
public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;

	private int measurementId;
	private Date dateOfBirth;
	private Date dateOfMeasurement = new Date();
	private BigDecimal headCircumference;
	private BigDecimal height;
	private BigDecimal weight;
	private int userProfileId;
	private DiagnosisMaster diagnosisMaster;

	public Measurement() {
	}

	public int getMeasurementId() {
		return this.measurementId;
	}

	public void setMeasurementId(int measurementId) {
		this.measurementId = measurementId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfMeasurement() {
		return this.dateOfMeasurement;
	}

	public void setDateOfMeasurement(Date dateOfMeasurement) {
		this.dateOfMeasurement = dateOfMeasurement;
	}

	public BigDecimal getHeadCircumference() {
		return this.headCircumference;
	}

	public void setHeadCircumference(BigDecimal headCircumference) {
		this.headCircumference = headCircumference;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public DiagnosisMaster getDiagnosisMaster() {
		return this.diagnosisMaster;
	}

	public void setDiagnosisMaster(DiagnosisMaster diagnosisMaster) {
		this.diagnosisMaster = diagnosisMaster;
	}
	
	public int getUserProfileId() {
		return this.userProfileId;
	}

	public void setUserProfileId(int userProfile) {
		this.userProfileId = userProfile;
	}
}