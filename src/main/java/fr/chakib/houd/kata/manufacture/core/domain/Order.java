package fr.chakib.houd.kata.manufacture.core.domain;

import java.math.BigDecimal;

public class Order {

    private static final String DELIMITER = ":";
    private static final String INSTRUCTION_EMPTY = "";

    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int STICK_INDEX = 2;

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
        return extractExtraInstruction(SUGAR_INDEX);
    }

    public String extractStick(){
        return extractExtraInstruction(STICK_INDEX);
    }

    private String extractExtraInstruction(int stickIndex) {
        if (hasNotSugarInstruction())
            return INSTRUCTION_EMPTY;
        return extractInstructions()[stickIndex];
    }

    private boolean hasNotSugarInstruction() {
        return protocol.split(DELIMITER).length < 2;
    }

    private String[] extractInstructions() {
        return protocol.split(DELIMITER);
    }
}
