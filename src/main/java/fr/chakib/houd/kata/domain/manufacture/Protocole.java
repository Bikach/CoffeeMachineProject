package fr.chakib.houd.kata.domain.manufacture;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Protocole {

    private static final String DELIMITER = ":";
    private static final String TEA_PROTOCOLE = "T";
    private static final String COFFEE_PROTOCOLE = "C";
    private static final String INFORMATION_PROTOCOLE = "M";

    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int NO_SUGAR = 0;

    private final String order;

    public Protocole(String order) {
        this.order = order;
    }

    public String drink() {
        if(hasDrinkInstructionWithA(TEA_PROTOCOLE))
            return "tea";
        if(hasDrinkInstructionWithA(COFFEE_PROTOCOLE))
            return "coffee";
        return "chocolate";
    }

    public String sugar(){
        if(sugarNumber() > 0)
            return valueOf(sugarNumber());
        return "no";
    }

    public String stick(){
        if(sugarInstructionIsPresent())
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
        if(sugarInstructionIsPresent())
            return parseInt(sugarInstruction());
        return NO_SUGAR;
    }

    private boolean sugarInstructionIsPresent() {
        return extractInstructions().length >= 2;
    }

    private String sugarInstruction() {
        return extractInstructions()[SUGAR_INDEX];
    }
}
