package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;

public class TeaDrink extends Drink {

    public TeaDrink() {
        super("T", new BigDecimal("0.4"), "tea");
    }

    @Override
    public boolean validateSelection(String drinkSelected, BigDecimal amountReceived){
        verifiesThatAmountIsEnoughToCoverTheCosts(drinkSelected, amountReceived);
        return drinkSelected.contains(protocol) && receivedAnAmountAtLeastEqualToTheCost(amountReceived);
    }

    @Override
    public String instruction() {
        return instruction;
    }
}
