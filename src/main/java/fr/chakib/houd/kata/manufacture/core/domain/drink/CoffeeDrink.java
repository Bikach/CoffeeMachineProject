package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CoffeeDrink {

    private static final String PROTOCOL = "C";
    private static final BigDecimal AMOUNT = new BigDecimal("0.6");
    private static final String INSTRUCTION = "coffee";

    public boolean validProtocols(String drinkProtocol, String amountProtocol){
        var amountReceived = new BigDecimal(amountProtocol);
        if(PROTOCOL.equals(drinkProtocol) && AMOUNT.compareTo(amountReceived) > 0)
            throw new InsufficientAmountProtocolException(missingAmount(amountReceived), INSTRUCTION);
        return PROTOCOL.equals(drinkProtocol) && AMOUNT.compareTo(amountReceived) == 0;
    }

    public String instruction() {
        return INSTRUCTION;
    }

    private BigDecimal missingAmount(BigDecimal amountReceived){
        return AMOUNT.subtract(amountReceived).setScale(2, RoundingMode.HALF_UP);
    }
}