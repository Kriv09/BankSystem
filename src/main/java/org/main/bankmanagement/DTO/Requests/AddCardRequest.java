package org.main.bankmanagement.DTO.Requests;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.main.bankmanagement.Models.AppUser;
import org.main.bankmanagement.Models.Type.CardType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCardRequest extends Request {

    private Short pin;

    private AppUser appUser;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
}
