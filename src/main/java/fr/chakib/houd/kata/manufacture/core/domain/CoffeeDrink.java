package fr.chakib.houd.kata.manufacture.core.domain;

public class CoffeeDrink {

    private static final String PROTOCOL = "C";
    private static final float AMOUNT = 0.6f;

    public boolean validDrinkProtocol(String drinkProtocol) {
        return PROTOCOL.equals(drinkProtocol);
    }

    public boolean validAmountProtocol(String amountProtocol) {
        return AMOUNT == Float.parseFloat(amountProtocol);
    }
}
