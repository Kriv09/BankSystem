package org.main.bankmanagement.Services;

import org.main.bankmanagement.DTO.Requests.AddCardRequest;
import org.main.bankmanagement.Models.Card;
import org.main.bankmanagement.Repositories.CardRepository;
import org.main.bankmanagement.Utility.CardUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void saveCard(AddCardRequest cardRequest, String Userid) {

        Short cvv = CardUtils.generateRandomCVV();
        String number = CardUtils.generateRandomCardNumber(cardRequest.getCardType());

        Card card = Card.builder()
                .pin(cardRequest.getPin())
                .cardType(cardRequest.getCardType())
                .appUser(cardRequest.getAppUser())
                .expiryDate(LocalDate.now())
                .cardNumber(number)
                .expired(false)
                .cvv(cvv)
                .build();

        cardRepository.save(card);
    }
}
