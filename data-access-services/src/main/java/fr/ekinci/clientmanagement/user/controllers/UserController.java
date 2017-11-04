package fr.ekinci.clientmanagement.user.controllers;

import fr.ekinci.clientmanagement.user.services.AddressService;
import fr.ekinci.clientmanagement.user.services.PhoneService;
import fr.ekinci.clientmanagement.user.services.UserService;
import fr.ekinci.clientmodels.AddressDto;
import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.clientmodels.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

/**
 * @author Gokan EKINCI
 */
@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final UserService userService;
	private final PhoneService phoneService;
	private final AddressService addressService;


	@Autowired
	public UserController(UserService userService, PhoneService phoneService, AddressService addressService) {
		this.userService = userService;
		this.phoneService = phoneService;
		this.addressService = addressService;
	}



	/**
	 * If page and size request parameters are filled, return a page. Otherwise, return a list of all elements.
	 *
	 * @param page      Page index, starts with 0
	 * @param size      Page size
	 * @return          Can return a TODO @link org.springframework.data.domain.Page OR a {@link List} of DTO
	 */
	@GetMapping
	public ResponseEntity<?> get(
		@RequestParam(value = "page", required = false) Integer page,
		@RequestParam(value = "size", required = false) Integer size
	) {
		if (page != null && size != null) {
			// TODO
		}

		final List<UserDto> userDtoList = userService.getAll();

		if (!userDtoList.isEmpty()) {
            return new ResponseEntity<>(userDtoList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> get(@PathVariable @Valid @Pattern(regexp = "[0-9]{1,}") String id) {
        final Optional<UserDto> dtoOpt = userService.getUserById(id);
        return (dtoOpt.isPresent()) ?
                new ResponseEntity<>(dtoOpt.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



	@PostMapping
	public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
		return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
	}



	@PutMapping(path = "/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDto userDto) {
		userService.update(id, userDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}



	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "/{id}/phones")
	public ResponseEntity<PhoneDto> addPhoneToUser(@PathVariable Long id, @RequestBody PhoneDto phoneDto) {
		return new ResponseEntity<>(phoneService.create(id, phoneDto), HttpStatus.OK);
	}

	@PostMapping(path = "/{id}/address")
	public ResponseEntity<PhoneDto> addAddressToUser(@PathVariable Long id, @RequestBody AddressDto addressDto) {
		return new ResponseEntity<>(addressService.create(id, addressDto), HttpStatus.OK);
	}
}
