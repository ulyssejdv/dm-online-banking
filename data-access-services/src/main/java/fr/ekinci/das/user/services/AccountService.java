package fr.ekinci.das.user.services;

import fr.ekinci.clientmodels.AccountDto;
import fr.ekinci.das.user.entities.AccountEntity;
import fr.ekinci.das.user.entities.UserEntity;
import fr.ekinci.das.user.repositories.AccountRepository;
import fr.ekinci.das.user.repositories.UserRepository;
import fr.ekinci.das.user.services.interfaces.IAccountService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class AccountService implements IAccountService {

	private final AccountRepository accountRepository;
	private final UserRepository userRepository;

	@Autowired
	public AccountService(
			AccountRepository accountRepository,
			UserRepository userRepository
    ) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}

	@Override
	public AccountDto create(Long idUser, AccountDto accountDto) {

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setSolde(accountDto.getSolde());
		accountEntity.setTypeAccount(accountDto.getTypeAccount());

		accountEntity.setUser(userRepository.findOne(idUser));

        accountEntity = accountRepository.save(accountEntity);

        accountDto.setId(String.valueOf(accountEntity.getId()));

        return accountDto;
	}
}
