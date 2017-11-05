package fr.ekinci.das.user.repositories;

import fr.ekinci.das.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	List<UserEntity> findAll();
}
