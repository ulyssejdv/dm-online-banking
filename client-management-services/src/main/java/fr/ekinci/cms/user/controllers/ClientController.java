package fr.ekinci.cms.user.controllers;

import fr.ekinci.clientmodels.UserDto;
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

	@Autowired
	public ClientController() {
		this.userRequest = new UserRequest();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> get(@PathVariable String id) {

        UserDto userDto = userRequest.get(id);

        final Optional<UserDto> dtoOpt = Optional.of(userDto);
		return (dtoOpt.isPresent()) ?
			new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
		return new ResponseEntity<>(UserDto.builder().build(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto user) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		// TODO
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
