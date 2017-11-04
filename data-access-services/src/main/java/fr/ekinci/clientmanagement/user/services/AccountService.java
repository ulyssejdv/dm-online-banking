package fr.ekinci.clientmanagement.user.services;

import fr.ekinci.clientmanagement.user.repositories.AccountRepository;
import fr.ekinci.clientmanagement.user.services.interfaces.IAccountService;
import fr.ekinci.clientmodels.AccountDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class AccountService implements IAccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository, UserService userService) {
		this.accountRepository = accountRepository;
	}

}
