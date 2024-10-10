package org.main.bankmanagement.Controllers;

import org.main.bankmanagement.DTO.Requests.AddCardRequest;
import org.main.bankmanagement.DTO.Requests.RequestState;
import org.main.bankmanagement.Services.AppUserService;
import org.main.bankmanagement.Services.CardService;
import org.main.bankmanagement.Utility.RequestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cards")
public class CardController {

    private final CardService cardService;
    private final AppUserService appUserService;

    public CardController(CardService cardService, AppUserService appUserService) {
        this.cardService = cardService;
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<String> AddNewCard(@RequestBody AddCardRequest request) {
        RequestState state = RequestUtils.checkRequestState(request);
        if(!appUserService.idExists(request.getUserId())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User does not exist");
        }

        return switch (state) {
            case EMPTY -> ResponseEntity.badRequest().body("Request is empty.");
            case FULL -> {
                cardService.saveCard(request);
                yield ResponseEntity.status(HttpStatus.CREATED).body("Card created successfully.");
            }
        };
    }
}
