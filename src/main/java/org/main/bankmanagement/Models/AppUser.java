package org.main.bankmanagement.Models;


import org.main.bankmanagement.DTO.Requests.AddUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String password;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public AppUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
}

    public static AppUser parse(AddUserRequest request)
    {
        return new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword()
        );
    }
}
