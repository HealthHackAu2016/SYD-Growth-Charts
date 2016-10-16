package au.com.garvan.growth.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;

	@Column(name="username")
	private String username;

	@Column(name="password")
	private String password;

	@Column(name="unit_of_measure")
	private String unitOfMeasure;
	
	@Column(name="email_address")
	private String emailAddress;

	@Column(name="receive_emails")
	private String receiveEmails;

	//bi-directional many-to-one association to UserProfile
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="account_id")
	private List<UserProfile> userProfiles;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserProfile> getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	public ReceiveEmails getReceiveEmails() {
		return ReceiveEmails.valueOf(this.receiveEmails);
	}

	public void setReceiveEmails(ReceiveEmails receiveEmails) {
		this.receiveEmails = receiveEmails.toString();
	}

	public UnitOfMeasurement getUnitOfMeasure() {
		return UnitOfMeasurement.valueOf(this.unitOfMeasure);
	}

	public void setUnitOfMeasure(UnitOfMeasurement unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure.toString();
	}

	public UserProfile addUserProfile(UserProfile userProfile) {
		getUserProfiles().add(userProfile);
		userProfile.setAccountId(this.accountId);
		return userProfile;
	}

	public UserProfile removeUserProfile(UserProfile userProfile) {
		getUserProfiles().remove(userProfile);
//		userProfile.setAccountId(null);

		return userProfile;
	}
	
	public enum ReceiveEmails{
		Y, N
	}
	
	public enum UnitOfMeasurement{
		M, I
	}
}