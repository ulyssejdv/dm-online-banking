package fr.ekinci.das.user.services;

import fr.ekinci.das.user.entities.UserEntity;
import fr.ekinci.das.user.repositories.AccountRepository;
import fr.ekinci.das.user.repositories.UserRepository;
import fr.ekinci.das.user.services.interfaces.IUserService;
import fr.ekinci.clientmodels.UserDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;
	private final AccountRepository accountRepository;

	@Autowired
	public UserService(UserRepository userRepository, AccountRepository accountRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}

	@Override
	public List<UserDto> getAll() {
		return userRepository.findAll()
			.stream()
			.map(
				u -> UserDto.builder()
				.id(String.valueOf(u.getId()))
				.firstName(u.getFirstName())
				.lastName(u.getLastName())
				.build()
			)
			.collect(Collectors.toList());
	}

	@Override
	public Optional<UserDto> getUserById(String id) {

		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));

		if (userEntity != null) {
            UserDto userDto = UserDto.builder()
                    .id(String.valueOf(userEntity.getId()))
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .build();
            return Optional.of(userDto);
        }

		return Optional.empty();
	}

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());

		UserEntity userEntity1 = userRepository.save(userEntity);
		return UserDto.builder()
			.id(String.valueOf(userEntity1.getId()))
			.firstName(userEntity1.getFirstName())
			.lastName(userEntity1.getLastName())
			.build();
	}

	@Override
	public void delete(String id) {
		userRepository.delete(Long.parseLong(id));
	}

	@Override
	public void update(String id, UserDto userDto) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userRepository.save(userEntity);
	}
}
