package org.main.bankmanagement.DTO.Requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest extends Request {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
