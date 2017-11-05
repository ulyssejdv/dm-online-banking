package fr.ekinci.das.user.repositories;

import fr.ekinci.das.user.entities.PhoneEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ulysse on 03/11/2017.
 */
public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {
}
