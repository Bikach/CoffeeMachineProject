package fr.chakib.houd.kata.manufacture.core.domain;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Protocol {

    private static final String DELIMITER = ":";
    private static final String CHOCOLATE_PROTOCOLE = "H";
    private static final String INFORMATION_PROTOCOLE = "M";

    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int NO_SUGAR = 0;

    private final String order;
    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();

    public Protocol(String order) {
        this.order = order;
    }

    public String drink() {
        if(tea.validDrinkProtocol(drinkProtocole()) && tea.validAmountProtocol(amountProtocol()))
            return "tea";
        if(coffee.validDrinkProtocol(drinkProtocole()) && coffee.validAmountProtocol(amountProtocol()))
            return "coffee";
        if(chocolate.validDrinkProtocol(drinkProtocole()) && chocolate.validAmountProtocol(amountProtocol()))
            return "chocolate";
        throw new DrinkProtocoleException();
    }

    private String drinkProtocole() {
        return extractInstructions()[DRINK_INDEX];
    }

    private String amountProtocol() {
        return extractInstructions()[AMOUNT_INDEX];
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
        return drinkProtocole().equals(drinkProtocole);
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

    private String amountInstruction() {
        if(extractInstructions().length < 3)
            return "0";
        return extractInstructions()[2];
    }
}
