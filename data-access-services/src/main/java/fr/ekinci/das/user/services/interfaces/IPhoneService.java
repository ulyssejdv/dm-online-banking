package fr.ekinci.das.user.services.interfaces;

import fr.ekinci.clientmodels.PhoneDto;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    List<PhoneDto> getAll();

    Optional<PhoneDto> getPhoneById(String id);

    PhoneDto create(Long idUser, PhoneDto phoneDto);

    void delete(String id);

    void update(String id, PhoneDto phoneDto);
}
