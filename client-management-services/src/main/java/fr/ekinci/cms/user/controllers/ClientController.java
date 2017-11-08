package fr.ekinci.cms.user.controllers;

import fr.ekinci.clientmodels.AccountDto;
import fr.ekinci.clientmodels.AddressDto;
import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.clientmodels.UserDto;
import fr.jdv.request.AddressRequest;
import fr.jdv.request.PhoneRequest;
import fr.jdv.request.UserRequest;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Gokan EKINCI
 */
@Log
@RestController
@RequestMapping(path = "/clients")
public class ClientController {

	private final UserRequest userRequest;
	private final PhoneRequest phoneRequest;
	private final AddressRequest addressRequest;

	@Autowired
	public ClientController() {
		this.userRequest = new UserRequest();
        this.phoneRequest = new PhoneRequest();
        this.addressRequest = new AddressRequest();
    }

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable String id) {
        UserDto userDto = userRequest.get(id);
        log.info(userDto.toString());
        final Optional<UserDto> dtoOpt = Optional.of(userDto);
		return (dtoOpt.isPresent()) ? new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        user = userRequest.post(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}/addresses", method = RequestMethod.POST)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody AddressDto addressDto) {
		UserDto userDto = userRequest.get(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

    @RequestMapping(path = "/{id}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> addAccount(@PathVariable String id, @RequestBody AccountDto accountDto) {
        accountDto = userRequest.postAccount(id, accountDto);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
