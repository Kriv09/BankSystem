package org.main.bankmanagement.Models.Type;

public enum CardType {
    DEBIT("Debit Card"),
    CREDIT("Credit Card"),
    VIRTUAL("Virtual Card"),
    BUSINESS("Business Card");

    private final String description;

    CardType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}