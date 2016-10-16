package au.com.garvan.growth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.garvan.growth.dao.AccountDao;
import au.com.garvan.growth.model.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public Account save(Account measurement){
		return accountDao.save(measurement);
	}
	
	public Iterable<Account> findAll(){
		return accountDao.findAll();
	}
	
	public Account findOne(int id){
		return accountDao.findOne(id);
	}
	
	public Account findByUsername(String username){
		return accountDao.findByUsername(username);
	}
	
	public Account update(Account account){
		Account  persistedMeasurement = accountDao.findOne(account.getAccountId());
		//TODO add update method to Account  
		return accountDao.save(persistedMeasurement);
	}
	
}
