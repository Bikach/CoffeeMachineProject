package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;

public class ChocolateDrink extends Drink {

    public ChocolateDrink() {
        super("H", new BigDecimal("0.5"), "chocolate");
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
