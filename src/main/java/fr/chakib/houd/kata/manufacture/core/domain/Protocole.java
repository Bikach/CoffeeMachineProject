package fr.chakib.houd.kata.manufacture.core.domain;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Protocole {

    private static final String DELIMITER = ":";
    private static final String TEA_PROTOCOLE = "T";
    private static final String COFFEE_PROTOCOLE = "C";
    private static final String CHOCOLATE_PROTOCOLE = "H";
    private static final String INFORMATION_PROTOCOLE = "M";

    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int NO_SUGAR = 0;

    private final String order;

    public Protocole(String order) {
        this.order = order;
    }

    public String drink() {
        if(hasDrinkInstructionWithA(TEA_PROTOCOLE) && amountInstruction().equals("0.4"))
            return "tea";
        if(hasDrinkInstructionWithA(COFFEE_PROTOCOLE) && amountInstruction().equals("0.6"))
            return "coffee";
        if(hasDrinkInstructionWithA(CHOCOLATE_PROTOCOLE) && amountInstruction().equals("0.5"))
            return "chocolate";
        throw new DrinkProtocoleException();
    }

    public String sugar(){
        if(sugarNumber() > 0)
            return valueOf(sugarNumber());
        return "no";
    }

    public String stick(){
        if(hasAtLeastOneSugar())
            return "a";
        return "therefore no";
    }

    public boolean containInformationProtocole() {
        return hasDrinkInstructionWithA(INFORMATION_PROTOCOLE);
    }

    private String[] extractInstructions() {
        return order.split(DELIMITER);
    }

    private boolean hasDrinkInstructionWithA(String drinkProtocole) {
        return extractInstructions()[DRINK_INDEX].equals(drinkProtocole);
    }

    private int sugarNumber(){
        if(hasAtLeastOneSugar())
            return parseInt(sugarInstruction());
        return NO_SUGAR;
    }

    private boolean hasAtLeastOneSugar() {
        return parseInt(extractInstructions()[SUGAR_INDEX]) > 0;
    }

    private String sugarInstruction() {
        return extractInstructions()[SUGAR_INDEX];
    }

    private boolean hasNotAmountGreaterThanAZero() {
        return amountInstruction().equals("0");
    }

    private String amountInstruction() {
        if(extractInstructions().length < 3)
            return "0";
        return extractInstructions()[2];
    }
}
