package fr.ekinci.das.user.repositories;

import fr.ekinci.das.user.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ulysse on 03/11/2017.
 */
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

}
