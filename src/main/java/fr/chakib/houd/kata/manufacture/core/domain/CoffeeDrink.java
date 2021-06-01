package fr.chakib.houd.kata.manufacture.core.domain;

public class CoffeeDrink {

    private static final String PROTOCOL = "C";
    private static final float AMOUNT = 0.6f;
    private static final String INSTRUCTION = "coffee";

    public boolean validProtocols(String drinkProtocol, String amountProtocol){
        return PROTOCOL.equals(drinkProtocol) && AMOUNT == Float.parseFloat(amountProtocol);
    }

    public String instruction() {
        return INSTRUCTION;
    }
}
