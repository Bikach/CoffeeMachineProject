package fr.chakib.houd.kata.manufacture.core.domain.drink;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Drink {

    protected static final String DEFAULT_QUANTITY = " one ";

    protected final String protocol;
    protected final BigDecimal amount;
    protected final String instruction;

    protected Drink(String protocol, BigDecimal amount, String instruction) {
        this.protocol = protocol;
        this.amount = amount;
        this.instruction = instruction;
    }

    public abstract boolean validateSelection(String drinkSelected, BigDecimal amount);
    public abstract String instruction();

    protected void verifiesThatAmountIsEnoughToCoverTheCosts(String drinkSelected, BigDecimal amountReceived) {
        if(protocol.equals(drinkSelected) && amount.compareTo(amountReceived) > 0)
            throw new InsufficientAmountProtocolException(missingAmount(amount, amountReceived), instruction);
    }

    protected boolean receivedAnAmountAtLeastEqualToTheCost(BigDecimal amountReceived) {
        return amount.compareTo(amountReceived) <= 0;
    }

    private BigDecimal missingAmount(BigDecimal amountDrink, BigDecimal amountReceived){
        return amountDrink.subtract(amountReceived).setScale(2, RoundingMode.HALF_UP);
    }
}
