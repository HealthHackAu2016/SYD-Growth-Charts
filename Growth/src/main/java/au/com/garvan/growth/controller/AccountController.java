package au.com.garvan.growth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.garvan.growth.model.Account;
import au.com.garvan.growth.service.AccountService;

@RestController
public class AccountController implements ControllerConstants {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value=ACCOUNTS_BASE, method=RequestMethod.POST)
	public Account save(@RequestBody Account measurement){
		return accountService.save(measurement);
	}
	
//	@RequestMapping(value=ACCOUNTS_BASE+"/{accountId}")
//	public Account findOne(@PathVariable("accountId") int id){
//		return accountService.findOne(id);
//	}
	
	@RequestMapping(value=ACCOUNTS_BASE+"/authenticate")
	public Account findOne(@RequestParam("username") String username, @RequestParam("password") String password){
		Account account = accountService.findByUsername(username);
		if (account==null || account.getPassword()==null ||
				(!account.getPassword().equals(password)) ) {
			return null;
		}
		return account;
	}
	
	//TODO fix update method
	@RequestMapping(value=ACCOUNTS_BASE+"/{accountId}", method=RequestMethod.PUT)
	public Account update(@RequestBody Account account){
		return accountService.update(account);
	}
	
//	@RequestMapping("/")
//	public Iterable<Account> findAll(){
//		return accountService.findAll();
//	}
}
