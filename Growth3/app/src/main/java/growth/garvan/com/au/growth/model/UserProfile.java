package growth.garvan.com.au.growth.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_profile database table.
 * 
 */
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private int profileId;
	private String profileName;
	private Date dateOfBirth;
	private String collectData;
	private String gender;
	private int diagnosisId;
	private List<Measurement> measurements;
	private int accountId;
	//private Account account;

	public UserProfile() {
	}

	public int getProfileId() {
		return this.profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	public int getDiagnosisId() {
		return this.diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	
	public CollectData getCollectData() {
		return CollectData.valueOf(this.collectData);
	}

	public void setCollectData(CollectData collectData) {
		this.collectData = collectData.toString();
	}
	
	public GenderType getGender() {
		return GenderType.valueOf(this.gender);
	}

	public void setGender(GenderType gender) {
		this.gender = gender.toString();
	}
	
	public List<Measurement> getMeasurements() {
		return this.measurements;
	}

	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

	public Measurement addMeasurement(Measurement measurement) {
		getMeasurements().add(measurement);
		measurement.setUserProfileId(this.getProfileId());
		return measurement;
	}

	public Measurement removeMeasurement(Measurement measurement) {
		getMeasurements().remove(measurement);
		return measurement;
	}
	
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public enum GenderType{
		M, F
	}

	public enum CollectData{
		Y, N
	}
}