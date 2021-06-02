package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ChocolateDrink {

    private static final String PROTOCOL = "H";
    private static final BigDecimal AMOUNT = new BigDecimal("0.5");
    private static final String INSTRUCTION = "chocolate";

    public boolean validateSelection(String drinkSelected, BigDecimal amount){
        if(PROTOCOL.equals(drinkSelected) && AMOUNT.compareTo(amount) > 0)
            throw new InsufficientAmountProtocolException(missingAmount(amount), INSTRUCTION);
        return PROTOCOL.equals(drinkSelected) && AMOUNT.compareTo(amount) <= 0;
    }

    public String instruction() {
        return INSTRUCTION;
    }

    private BigDecimal missingAmount(BigDecimal amountProtocol){
        return AMOUNT.subtract(amountProtocol).setScale(2, RoundingMode.HALF_UP);
    }
}
