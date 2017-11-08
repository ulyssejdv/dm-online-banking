package fr.ekinci.das.user.services.interfaces;

import fr.ekinci.clientmodels.AccountDto;
import fr.ekinci.clientmodels.AddressDto;

public interface IAccountService {
    AccountDto create(Long idUser, AccountDto accountDto);
}
