package au.com.garvan.growth.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the measurements database table.
 * 
 */
@Entity
@Table(name="measurements")
@NamedQueries({
		@NamedQuery(name="Measurement.findAll", query="SELECT m FROM Measurement m")
})
public class Measurement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="measurement_id")
	private int measurementId;

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_measurement")
	private Date dateOfMeasurement = new Date();

	@Column(name="head_circumference")
	private BigDecimal headCircumference;

	private BigDecimal height;

	private BigDecimal weight;

	//bi-directional many-to-one association to UserProfile
//	@ManyToOne
//	@JoinColumn(name="profile_id")
//	private UserProfile userProfile;
	@Column(name="profile_id")
	private int userProfileId;

	//uni-directional many-to-one association to DiagnosisMaster
	@ManyToOne
	@JoinColumn(name="diagnosis_id")
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
//	public UserProfile getUserProfile() {
//		return this.userProfile;
//	}
//
//	public void setUserProfile(UserProfile userProfile) {
//		this.userProfile = userProfile;
//	}
}