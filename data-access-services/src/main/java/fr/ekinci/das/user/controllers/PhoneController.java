package fr.ekinci.das.user.controllers;

import fr.ekinci.das.user.services.PhoneService;
import fr.ekinci.clientmodels.PhoneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/phones")
public class PhoneController {

	private final PhoneService phoneService;

	@Autowired
	public PhoneController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@GetMapping
	public ResponseEntity<?> get() {
		return null;
	}


	@GetMapping(path = "/{id}")
	public ResponseEntity<PhoneDto> get(@PathVariable String id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody PhoneDto phoneDto) {
		return null;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return null;
	}

}
