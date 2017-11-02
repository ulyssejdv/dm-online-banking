package fr.ekinci.clientmanagement.user.services;

import fr.ekinci.clientmanagement.user.entities.PhoneEntity;
import fr.ekinci.clientmanagement.user.entities.UserEntity;
import fr.ekinci.clientmanagement.user.repositories.UserRepository;
import fr.ekinci.clientmodels.AddressDto;
import fr.ekinci.clientmodels.PhoneDto;
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

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
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
		log.info(userEntity.toString());
		return (userEntity != null) ?
			Optional.of(
				UserDto.builder()
						.id(String.valueOf(userEntity.getId()))
						.firstName(userEntity.getFirstName())
						.lastName(userEntity.getLastName())
						.address(AddressDto.builder()
								.code(userEntity.getAddress().getCode())
								.country(userEntity.getAddress().getCountry())
								.id(String.valueOf(userEntity.getAddress().getId()))
								.street(userEntity.getAddress().getStreet())
								.build()
						)
						.phones(userEntity.getPhones().stream().map(
								p -> PhoneDto.builder()
										.id(String.valueOf(p.getId()))
										.label(p.getLabel())
										.number(p.getNumber())
										.build()
						).collect(Collectors.toList()))
						.build()
			)
			: Optional.empty();
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

	}

	@Override
	public void updateAddress(String id, AddressDto addressDto) {
		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		userEntity.getAddress().setCode(addressDto.getCode());
		userEntity.getAddress().setCountry(addressDto.getCountry());
		userEntity.getAddress().setStreet(addressDto.getStreet());
		userRepository.save(userEntity);
	}

	@Override
	public void addPhoneToUser(String id, PhoneDto p) {

		PhoneEntity phoneEntity = new PhoneEntity();
		phoneEntity.setLabel(p.getLabel());
		phoneEntity.setNumber(p.getNumber());

		UserEntity userEntity = userRepository.findOne(Long.parseLong(id));
		userEntity.getPhones().add(phoneEntity);
		log.info(userEntity.getPhones().toString());

		userRepository.save(userEntity);
	}
}
