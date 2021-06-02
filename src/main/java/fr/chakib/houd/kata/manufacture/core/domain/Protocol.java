package fr.chakib.houd.kata.manufacture.core.domain;

public class Protocol {

    private static final String DELIMITER = ":";
    private static final String INFORMATION_PROTOCOLE = "M";

    private static final int DRINK_INDEX = 0;
    private static final int SUGAR_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();
    private final Sugar sugar = new Sugar();

    private final String order;

    public Protocol(String order) {
        this.order = order;
    }

    public String drink() {
        if(tea.validProtocols(drinkProtocole(), amountProtocol()))
            return tea.instruction();
        if(coffee.validProtocols(drinkProtocole(), amountProtocol()))
            return coffee.instruction();
        if(chocolate.validProtocols(drinkProtocole(), amountProtocol())) {
            return chocolate.instruction();
        }
        throw new DrinkProtocoleException();
    }

    private String[] extractInstructions() {
        return order.split(DELIMITER);
    }

    private String drinkProtocole() {
        return extractInstructions()[DRINK_INDEX];
    }

    private String amountProtocol() {
        return extractInstructions()[AMOUNT_INDEX];
    }

    private String extractSugar() {
        return extractInstructions()[SUGAR_INDEX];
    }

    public String sugar(){
        return sugar.instruction(extractSugar());
    }

    public String stick(){
        return sugar.stickInstruction();
    }

    public boolean containInformationProtocole() {
        return drinkProtocole().equals(INFORMATION_PROTOCOLE);
    }
}
