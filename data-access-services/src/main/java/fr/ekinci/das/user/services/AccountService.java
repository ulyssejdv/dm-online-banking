package fr.ekinci.das.user.services;

import fr.ekinci.das.user.repositories.AccountRepository;
import fr.ekinci.das.user.services.interfaces.IAccountService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class AccountService implements IAccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository, UserService userService) {
		this.accountRepository = accountRepository;
	}

}
