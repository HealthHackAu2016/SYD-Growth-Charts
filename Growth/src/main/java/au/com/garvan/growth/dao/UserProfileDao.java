package au.com.garvan.growth.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import au.com.garvan.growth.model.UserProfile;

@Transactional
public interface UserProfileDao extends CrudRepository<UserProfile, Integer> {
	
	public List<UserProfile> findByAccountId(@Param("accountId") int accountId);
	
}
