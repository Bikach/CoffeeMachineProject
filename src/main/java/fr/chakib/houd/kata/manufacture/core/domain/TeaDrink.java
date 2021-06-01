package fr.chakib.houd.kata.manufacture.core.domain;

public class TeaDrink {

    private static final String PROTOCOL = "T";
    private static final float AMOUNT = 0.4f;

    public boolean validDrinkProtocol(String drinkProtocol) {
        return PROTOCOL.equals(drinkProtocol);
    }

    public boolean validAmountProtocol(String amountProtocol) {
        return AMOUNT == Float.parseFloat(amountProtocol);
    }
}
