package fr.ekinci.das.user.controllers;

import fr.ekinci.das.user.services.AddressService;
import fr.ekinci.clientmodels.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public ResponseEntity<?> get() {
		return null;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<AddressDto> get(@PathVariable String id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody AddressDto addressDto) {
		return null;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return null;
	}

}
