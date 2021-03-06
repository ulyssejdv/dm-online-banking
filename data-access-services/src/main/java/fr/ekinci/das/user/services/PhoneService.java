package fr.ekinci.das.user.services;

import fr.ekinci.das.user.entities.PhoneEntity;
import fr.ekinci.das.user.entities.UserEntity;
import fr.ekinci.das.user.repositories.PhoneRepository;
import fr.ekinci.das.user.repositories.UserRepository;
import fr.ekinci.das.user.services.interfaces.IPhoneService;
import fr.ekinci.clientmodels.PhoneDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class PhoneService implements IPhoneService {

	private final PhoneRepository phoneRepository;
	private final UserRepository userRepository;

	@Autowired
	public PhoneService(PhoneRepository phoneRepository, UserRepository userRepository) {
		this.phoneRepository = phoneRepository;
        this.userRepository = userRepository;
    }

	@Override
	public List<PhoneDto> getAll() {
		return null;
	}

	@Override
	public Optional<PhoneDto> getPhoneById(String id) {
		PhoneEntity phoneEntity = phoneRepository.findOne(Long.parseLong(id));
		return (phoneEntity != null) ?
			Optional.of(PhoneDto.builder()
					.id(String.valueOf(phoneEntity.getId()))
					.label(phoneEntity.getLabel())
					.number(phoneEntity.getNumber())
					.build()
			) : Optional.empty();
	}

	@Override
	public PhoneDto create(Long idUser, PhoneDto phoneDto) {

		return null;
	}

	@Override
	public void delete(String id) {
        phoneRepository.delete(Long.parseLong(id));
	}

	@Override
	public void update(String id, PhoneDto phoneDto) {

	}
}
