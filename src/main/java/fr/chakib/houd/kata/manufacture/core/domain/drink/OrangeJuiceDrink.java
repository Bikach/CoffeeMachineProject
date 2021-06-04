package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;

public class OrangeJuiceDrink extends Drink {

    public OrangeJuiceDrink() {
        super("O", new BigDecimal("0.6"), "orange juice");
    }

    @Override
    public boolean validateSelection(String drinkSelected, BigDecimal amountReceived){
        verifiesThatAmountIsEnoughToCoverTheCosts(drinkSelected, amountReceived);
        return protocol.equals(drinkSelected) && receivedAnAmountAtLeastEqualToTheCost(amountReceived);
    }

    @Override
    public String instruction() {
        return instruction;
    }
}
