package fr.chakib.houd.kata.manufacture.core.domain;

public class ChocolateDrink {

    private static final String PROTOCOL = "H";
    private static final float AMOUNT = 0.5f;

    public boolean validDrinkProtocol(String drinkProtocol) {
        return PROTOCOL.equals(drinkProtocol);
    }

    public boolean validAmountProtocol(String amountProtocol) {
        return AMOUNT == Float.parseFloat(amountProtocol);
    }
}
