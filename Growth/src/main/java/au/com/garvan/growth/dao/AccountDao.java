package au.com.garvan.growth.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import au.com.garvan.growth.model.Account;

@Transactional
public interface AccountDao extends CrudRepository<Account, Integer> {

	public Account findByUsername(String username);
	
}
