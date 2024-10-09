package org.main.bankmanagement.Repositories;


import org.main.bankmanagement.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends
        JpaRepository<AppUser,String> {
}
