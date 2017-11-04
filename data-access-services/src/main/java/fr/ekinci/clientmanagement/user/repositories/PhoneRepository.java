package fr.ekinci.clientmanagement.user.repositories;

import fr.ekinci.clientmanagement.user.entities.PhoneEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ulysse on 03/11/2017.
 */
public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
}
