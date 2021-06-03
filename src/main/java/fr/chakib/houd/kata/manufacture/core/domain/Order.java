package fr.chakib.houd.kata.manufacture.core.domain;

import java.math.BigDecimal;

public class Order {

    private static final String DELIMITER = ":";
    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int STICK_INDEX = 2;
    private static final String ZERO_SUGAR = "0";
    private static final String STICK_EMPTY = "";

    private final String protocol;
    private final BigDecimal amount;

    public Order(String protocol, BigDecimal amount) {
        this.protocol = protocol;
        this.amount = amount;
    }

    public String extractDrink() {
        return extractInstructions()[DRINK_INDEX];
    }

    public BigDecimal amount() {
        return amount;
    }

    public String extractSugar() {
        if(hasSugarInstruction())
            return ZERO_SUGAR;
        return extractInstructions()[SUGAR_INDEX];
    }

    public String extractStick(){
        if(hasSugarInstruction())
            return STICK_EMPTY;
        return extractInstructions()[STICK_INDEX];
    }

    private boolean hasSugarInstruction() {
        return protocol.split(DELIMITER).length < 2;
    }

    private String[] extractInstructions() {
        return protocol.split(DELIMITER);
    }
}
