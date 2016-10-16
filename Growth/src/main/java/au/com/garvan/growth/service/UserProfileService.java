package au.com.garvan.growth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.garvan.growth.dao.UserProfileDao;
import au.com.garvan.growth.model.UserProfile;

@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileDao userProfileDao;
	
	public UserProfile save(UserProfile diagnosisMaster){
		return userProfileDao.save(diagnosisMaster);
	}
	
	public Iterable<UserProfile> findAll(){
		return userProfileDao.findAll();
	}
	
	public Iterable<UserProfile> findByAccountId(int accountId){
		return userProfileDao.findByAccountId(accountId);
	}
	
	public UserProfile findOne(int id){
		return userProfileDao.findOne(id);
	}
	
	public UserProfile update(UserProfile userProfile){
		UserProfile  persistedUserProfile  = userProfileDao.findOne(userProfile.getProfileId());
		//TODO update UserProfile 
		return userProfileDao.save(persistedUserProfile);
	}
}
