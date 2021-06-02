package fr.chakib.houd.kata.manufacture.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Float.parseFloat;

public class ChocolateDrink {

    private static final String PROTOCOL = "H";
    private static final BigDecimal AMOUNT = new BigDecimal("0.5");
    private static final String INSTRUCTION = "chocolate";

    public boolean validProtocols(String drinkProtocol, String amountProtocol){
        var amountReceived = new BigDecimal(amountProtocol);
        if(PROTOCOL.equals(drinkProtocol) && AMOUNT.compareTo(amountReceived) > 0)
            throw new InsufficientAmountProtocolException(missingAmount(amountReceived), INSTRUCTION);
        return PROTOCOL.equals(drinkProtocol) && AMOUNT.compareTo(amountReceived) == 0;
    }

    public String instruction() {
        return INSTRUCTION;
    }

    private BigDecimal missingAmount(BigDecimal amountProtocol){
        return AMOUNT.subtract(amountProtocol).setScale(2, RoundingMode.HALF_UP);
    }
}
