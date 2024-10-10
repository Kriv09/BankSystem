package org.main.bankmanagement.Services;

import org.main.bankmanagement.DTO.Requests.AddCardRequest;
import org.main.bankmanagement.Models.AppUser;
import org.main.bankmanagement.Models.Card;
import org.main.bankmanagement.Repositories.CardRepository;
import org.main.bankmanagement.Utility.CardUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AppUserService appUserService;

    public CardService(CardRepository cardRepository, AppUserService appUserService) {
        this.cardRepository = cardRepository;
        this.appUserService = appUserService;
    }

    public void saveCard(AddCardRequest cardRequest) {

        Short cvv = CardUtils.generateRandomCVV();
        String number = CardUtils.generateRandomCardNumber(cardRequest.getCardType());
        AppUser appUser = appUserService.findUserById(cardRequest.getUserId()).get();

        Card card = Card.builder()
                .pin(cardRequest.getPin())
                .cardType(cardRequest.getCardType())
                .appUser(appUser)
                .expiryDate(LocalDate.now())
                .cardNumber(number)
                .expired(false)
                .cvv(cvv)
                .build();

        cardRepository.save(card);
    }
}
