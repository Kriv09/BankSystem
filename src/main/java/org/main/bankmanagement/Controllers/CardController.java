package org.main.bankmanagement.Controllers;

import org.main.bankmanagement.DTO.Requests.AddCardRequest;
import org.main.bankmanagement.DTO.Requests.RequestState;
import org.main.bankmanagement.Services.CardService;
import org.main.bankmanagement.Utility.RequestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> AddNewCard(@RequestBody AddCardRequest request, @PathVariable String id) {
        RequestState state = RequestUtils.checkRequestState(request);

        return switch (state) {
            case EMPTY -> ResponseEntity.badRequest().body("Request is empty.");
            case FULL -> {
                cardService.saveCard(request, id);
                yield ResponseEntity.status(HttpStatus.CREATED).body("User created successfully.");
            }
        };
    }
}
