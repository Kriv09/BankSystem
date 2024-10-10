package org.main.bankmanagement.Utility;

import org.main.bankmanagement.Models.Type.CardType;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Random;

public class CardUtils {
    public static String generateRandomCardNumber(CardType cardType) {
        String prefix = switch (cardType) {
            case DEBIT -> "4000";
            case CREDIT -> "5000";
            case VIRTUAL -> "6000";
            case BUSINESS -> "7000";
        };

        Random random = new Random();
        StringBuilder number = new StringBuilder(prefix);
        for (int i = 0; i < 12; i++) {
            number.append(random.nextInt(10));
        }

        return number.toString();
    }

    public static Short generateRandomCVV() {
        return (short) ThreadLocalRandom.current().nextInt(100, 1000);
    }
}
