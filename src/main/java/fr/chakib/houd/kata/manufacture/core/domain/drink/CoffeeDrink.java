package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;

public class CoffeeDrink extends Drink {

    public CoffeeDrink() {
        super("C", new BigDecimal("0.6"), "coffee");
    }

    @Override
    public boolean validateSelection(String drinkSelected, BigDecimal amountReceived){
        verifiesThatAmountIsEnoughToCoverTheCosts(drinkSelected, amountReceived);
        return protocol.equals(drinkSelected) && receivedAnAmountAtLeastEqualToTheCost(amountReceived);
    }

    @Override
    public String instruction() {
        return DEFAULT_QUANTITY + instruction;
    }
}
