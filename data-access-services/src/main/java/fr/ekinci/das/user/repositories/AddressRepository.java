package fr.ekinci.das.user.repositories;

import fr.ekinci.das.user.entities.AddressEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ulysse on 03/11/2017.
 */
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
    List<AddressEntity> findAll();
}
