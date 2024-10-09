package org.main.bankmanagement.Services;


import org.main.bankmanagement.DTO.Requests.AddUserRequest;
import org.main.bankmanagement.Models.AppUser;
import org.main.bankmanagement.Repositories.AppUserRepository;
import org.main.bankmanagement.Utility.BasedPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    private final BasedPasswordEncoder basedPasswordEncoder;

    public AppUserService(AppUserRepository appUserRepository, BasedPasswordEncoder basedPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.basedPasswordEncoder = basedPasswordEncoder;
    }

    //TODO: User CRUD operations { ADD[+] , DELETE , UPDATE , READ }

    public void save(AddUserRequest request) {

        AppUser appUser = AppUser.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .email(request.getEmail())
                .password(basedPasswordEncoder.encode(request.getPassword()))
                .createdOn(LocalDate.now())
                .build();

        appUserRepository.save(appUser);
    }

    public List<AppUser> getAll()
    {
        return appUserRepository.findAll();
    }
}
