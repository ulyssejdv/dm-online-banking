package fr.ekinci.clientmanagement.user.services;

import fr.ekinci.clientmanagement.user.entities.AddressEntity;
import fr.ekinci.clientmanagement.user.entities.UserEntity;
import fr.ekinci.clientmanagement.user.repositories.AddressRepository;
import fr.ekinci.clientmanagement.user.repositories.UserRepository;
import fr.ekinci.clientmanagement.user.services.interfaces.IAddressService;
import fr.ekinci.clientmodels.AddressDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Service
public class AddressService implements IAddressService {

	private final AddressRepository addressRepository;
	private final UserRepository userRepository;

	@Autowired
	public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<AddressDto> getAll() {
		return addressRepository.findAll()
				.stream()
				.map(
						u -> AddressDto.builder()
								.id(String.valueOf(u.getId()))
								.country(u.getCountry())
								.country(u.getCountry())
								.street(u.getStreet())
								.build()
				)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<AddressDto> getAddressById(String id) {
		AddressEntity addressEntity = addressRepository.findOne(Long.parseLong(id));
		return (addressEntity != null) ?
				Optional.of(
						AddressDto.builder()
								.id(String.valueOf(addressEntity.getId()))
								.country(addressEntity.getCountry())
								.country(addressEntity.getCountry())
								.street(addressEntity.getStreet())
								.build()
				)
				: Optional.empty();
	}

	@Override
	public AddressDto create(Long id, AddressDto addressDto) {

		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCode(addressDto.getCode());
		addressEntity.setCountry(addressDto.getCountry());
		addressEntity.setStreet(addressDto.getStreet());

		UserEntity userEntity = userRepository.findOne(Long.parseLong(addressDto.getUser().getId()));
        addressEntity.setUser(userEntity);

        addressEntity = addressRepository.save(addressEntity);

		return AddressDto.builder()
                .street(addressEntity.getStreet())
                .code(addressEntity.getCode())
                .country(addressEntity.getCountry())
                .id(String.valueOf(addressEntity.getId()))
                .build();
	}

	@Override
	public void delete(String id) {
        addressRepository.delete(Long.parseLong(id));
	}

	@Override
	public void update(String id, AddressDto addressDto) {
		AddressEntity addressEntity = addressRepository.findOne(Long.parseLong(id));
		addressEntity.setStreet(addressDto.getStreet());
		addressEntity.setCountry(addressDto.getCountry());
		addressEntity.setCode(addressDto.getCode());
		addressRepository.save(addressEntity);
	}
}
