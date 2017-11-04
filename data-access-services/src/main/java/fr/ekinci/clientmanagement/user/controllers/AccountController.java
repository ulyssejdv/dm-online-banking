package fr.ekinci.clientmanagement.user.controllers;

import fr.ekinci.clientmanagement.user.services.AccountService;
import fr.ekinci.clientmanagement.user.services.UserService;
import fr.ekinci.clientmodels.AccountDto;
import fr.ekinci.clientmodels.PhoneDto;
import fr.ekinci.clientmodels.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by ulysse on 03/11/2017.
 */
@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> create() {
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable String id) {
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
