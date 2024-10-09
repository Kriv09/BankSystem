package org.main.bankmanagement.Services;


import org.main.bankmanagement.Models.AppUser;
import org.main.bankmanagement.Repositories.AppUserRepository;
import org.main.bankmanagement.Utility.BasedPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BasedPasswordEncoder basedPasswordEncoder;

    //TODO: User CRUD operations { ADD[+] , DELETE , UPDATE , READ }

    public void save(AppUser appUser) {
        //Prepare the user data
        appUser.setPassword(basedPasswordEncoder.encode(appUser.getPassword()));

        //Save the data
        appUserRepository.save(appUser);
    }

    public List<AppUser> getAll()
    {
        return appUserRepository.findAll();
    }
}
