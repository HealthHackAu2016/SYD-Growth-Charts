package au.com.garvan.growth.controller;

public interface ControllerConstants {
	public static final String ACCOUNTS_BASE="/accounts";
	public static final String PROFILES_BASE="/accounts/{accountId}/userprofiles";
	public static final String ALL_MEASUREMENTS="/measurements";
	public static final String MEASUREMENT_BASE="/accounts/{accountId}/userprofiles/{profileId}/measurements";
	public static final String DIAGNOSIS_BASE="/diagnosis";
}
