package org.main.bankmanagement.DTO.Requests;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.main.bankmanagement.Models.Type.CardType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCardRequest extends Request {

    private Short pin;

    private String userId;

    @Enumerated(EnumType.STRING)
    private CardType cardType;
}
