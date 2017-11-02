package fr.ekinci.clientmanagement.user.services;

import fr.ekinci.clientmodels.AddressDto;
import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.clientmodels.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	List<UserDto> getAll();

	Optional<UserDto> getUserById(String id);

	UserDto create(UserDto userDto);

	void delete(String id);

	void update(String id, UserDto userDto);

	void updateAddress(String id, AddressDto addressDto);

	void addPhoneToUser(String id, PhoneDto p);
}
