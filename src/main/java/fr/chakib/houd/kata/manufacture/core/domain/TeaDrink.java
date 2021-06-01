package fr.chakib.houd.kata.manufacture.core.domain;

public class TeaDrink {

    private static final String PROTOCOL = "T";
    private static final float AMOUNT = 0.4f;
    private static final String INSTRUCTION = "tea";

    public boolean validProtocols(String drinkProtocol, String amountProtocol){
        return PROTOCOL.equals(drinkProtocol) && AMOUNT == Float.parseFloat(amountProtocol);
    }

    public String instruction() {
        return INSTRUCTION;
    }
}
