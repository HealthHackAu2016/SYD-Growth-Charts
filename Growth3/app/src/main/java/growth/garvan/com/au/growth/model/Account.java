package growth.garvan.com.au.growth.model;

import java.io.Serializable;
import java.util.List;
/**
 * The persistent class for the accounts database table.
 * 
 */
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private int accountId;
	private String username;
	private String password;
	private String unitOfMeasure;
	private String emailAddress;
	private String receiveEmails;
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