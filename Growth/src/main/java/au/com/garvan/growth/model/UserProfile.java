package au.com.garvan.growth.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_profile database table.
 * 
 */
@Entity
@Table(name="user_profile")
@NamedQueries({
	@NamedQuery(name="UserProfile.findAll", query="SELECT u FROM UserProfile u"),
	@NamedQuery(name="UserProfile.findByAccountId", query="SELECT u FROM UserProfile u where u.accountId=:accountId")
})
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profile_id")
	private int profileId;

	@Column(name="profile_name")
	private String profileName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="collect_data")
	private String collectData;

	@Column(name="gender")
	private String gender;
	
	@Column(name="diagnosis_id")
	private int diagnosisId;

	//bi-directional many-to-one association to Measurement
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="profile_id")
	private List<Measurement> measurements;

	//bi-directional many-to-one association to Account
	//@ManyToOne
	//@JoinColumn(name="account_id")
	@Column(name="account_id")
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
//		measurement.setUserProfile(null);

		return measurement;
	}

//	public Account getAccount() {
//		return this.account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}
	
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