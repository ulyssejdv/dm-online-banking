package fr.ekinci.clientmanagement.user.repositories;

import fr.ekinci.clientmanagement.user.entities.AddressEntity;
import fr.ekinci.clientmanagement.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 03/11/2017.
 */
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    List<AddressEntity> findAll();
}
