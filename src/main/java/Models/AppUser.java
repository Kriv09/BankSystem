package Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
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
}
