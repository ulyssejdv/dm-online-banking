package fr.ekinci.das.user.services;

import fr.ekinci.das.user.entities.AddressEntity;
import fr.ekinci.das.user.entities.UserEntity;
import fr.ekinci.das.user.repositories.AddressRepository;
import fr.ekinci.das.user.repositories.UserRepository;
import fr.ekinci.das.user.services.interfaces.IAddressService;
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
		return null;
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
