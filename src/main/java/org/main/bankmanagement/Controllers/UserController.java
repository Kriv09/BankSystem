package org.main.bankmanagement.Controllers;


import org.main.bankmanagement.DTO.Requests.AddUserRequest;
import org.main.bankmanagement.DTO.Requests.RequestState;
import org.main.bankmanagement.Models.AppUser;
import org.main.bankmanagement.Services.AppUserService;
import org.main.bankmanagement.Utility.RequestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final AppUserService appUserService;

    public UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @PostMapping
    public ResponseEntity<Object> addNewUser(@RequestBody AddUserRequest request) {
        RequestState state = RequestUtils.checkRequestState(request);

        // Handle request state
        switch (state) {
            case EMPTY:
                return ResponseEntity.badRequest().body("Request is empty.");
            case FULL:
                // Prepare the user for saving
                AppUser user = AppUser.parse(request);
                user.setCreatedOn(LocalDate.now());

                // Save the user
                appUserService.save(user);
                return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An unexpected error occurred.");
        }
    }

    @GetMapping
    public List<AppUser> getAllUsers()
    {
        return appUserService.getAll();
    }
}
