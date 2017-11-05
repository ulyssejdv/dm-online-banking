package fr.ekinci.das.user.services.interfaces;

import fr.ekinci.clientmodels.AddressDto;

import java.util.List;
import java.util.Optional;

public interface IAddressService {

    List<AddressDto> getAll();

    Optional<AddressDto> getAddressById(String id);

    AddressDto create(Long idUser, AddressDto addressDto);

    void delete(String id);

    void update(String id, AddressDto addressDto);
}
