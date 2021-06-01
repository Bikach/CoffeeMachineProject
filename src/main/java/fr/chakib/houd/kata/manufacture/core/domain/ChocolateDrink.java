package fr.chakib.houd.kata.manufacture.core.domain;

public class ChocolateDrink {

    private static final String PROTOCOL = "H";
    private static final float AMOUNT = 0.5f;
    private static final String INSTRUCTION = "chocolate";

    public boolean validProtocols(String drinkProtocol, String amountProtocol){
        return PROTOCOL.equals(drinkProtocol) && AMOUNT == Float.parseFloat(amountProtocol);
    }

    public String instruction() {
        return INSTRUCTION;
    }
}
