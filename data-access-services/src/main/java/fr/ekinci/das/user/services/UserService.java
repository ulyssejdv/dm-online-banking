package fr.ekinci.das.user.services;

import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.das.user.entities.AddressEntity;
import fr.ekinci.das.user.entities.PhoneEntity;
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

		if (userEntity != null) {
            UserDto userDto = UserDto.builder()
                    .id(String.valueOf(userEntity.getId()))
                    .firstName(userEntity.getFirstName())
                    .lastName(userEntity.getLastName())
                    .phones(userEntity.getPhones().stream().map(
                            p -> PhoneDto.builder()
                                    .label(p.getLabel())
                                    .number(p.getNumber())
                                    .id(String.valueOf(p.getId()))
                                    .build()
                    ).collect(Collectors.toList()))
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(userDto.getAddress().getStreet());
        addressEntity.setCode(userDto.getAddress().getCode());
        addressEntity.setCountry(userDto.getAddress().getCountry());
        userEntity.setAddress(addressEntity);

        userEntity.setPhones(userDto.getPhones()
                .stream()
                .map(
                        p -> {
                            PhoneEntity phoneEntity = new PhoneEntity();
                            phoneEntity.setLabel(p.getLabel());
                            phoneEntity.setNumber(p.getNumber());
                            return phoneEntity;
                        }
                )
                .collect(Collectors.toSet())
        );

        userEntity = userRepository.save(userEntity);

        userDto.setId(String.valueOf(userEntity.getId()));

		return userDto;
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
