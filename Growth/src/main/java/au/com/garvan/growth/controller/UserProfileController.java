package au.com.garvan.growth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.garvan.growth.model.UserProfile;
import au.com.garvan.growth.service.UserProfileService;
// /accounts/{accountId}/userprofiles
@RestController
public class UserProfileController implements ControllerConstants {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(value=PROFILES_BASE,method=RequestMethod.POST)
	public UserProfile save(@PathVariable("accountId")int accountId,@RequestBody UserProfile userProfile){
		return userProfileService.save(userProfile);
	}
	
	@RequestMapping(PROFILES_BASE)
	public Iterable<UserProfile> findAll(@PathVariable("accountId")int accountId){
		//return userProfileService.findAll();
		return userProfileService.findByAccountId(accountId);
	}
	
//	@RequestMapping("/userprofiles/findBy")
//	public Iterable<UserProfile> findAll(@RequestParam("accountId") int accountId){
//		return userProfileService.findByAccountId(accountId);
//	}
	
	@RequestMapping(PROFILES_BASE+"/{userProfileId}")
	public UserProfile findOne(@PathVariable("accountId")int accountId, @PathVariable("userProfileId") int id){
		return userProfileService.findOne(id);
	}
	
	//TODO test this
	@RequestMapping(value=PROFILES_BASE+"/{profileId}",method=RequestMethod.PUT)
	public UserProfile update(@PathVariable("accountId")int accountId, @RequestBody UserProfile userProfile){
		return userProfileService.update(userProfile);
	}
}
