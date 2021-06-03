package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.ChocolateDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.CoffeeDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountProtocolException;
import fr.chakib.houd.kata.manufacture.core.domain.drink.TeaDrink;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Stick;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Sugar;

import static java.lang.String.format;

public class OrderTranslator {

    private static final String INFORMATION_PROTOCOLE = "M";
    private static final String CUSTOMER_MESSAGE = "Drink maker makes 1 %s with %s sugar and %s stick";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();
    private final Sugar sugar = new Sugar();
    private final Stick stick = new Stick();

    private final Order order;

    public OrderTranslator(Order order) {
        this.order = order;
    }

    public String translate(){
        if(containInformationProtocole())
            return DEFAULT_MESSAGE;
        return formatMessageOrder();
    }

    private String formatMessageOrder() {
        try {
            return format(CUSTOMER_MESSAGE, drink(), sugar(), stick());
        }catch (InsufficientAmountProtocolException e){
            return e.getMessage();
        }
    }

    private String drink() {
        var instruction = "";
        if(tea.validateSelection(order.extractDrink(), order.amount()))
            instruction = tea.instruction();
        else if(coffee.validateSelection(order.extractDrink(), order.amount()))
            instruction = coffee.instruction();
        else if(chocolate.validateSelection(order.extractDrink(), order.amount()))
            instruction = chocolate.instruction();
        return instruction;
    }


    private String sugar(){
        return sugar.instruction(order.extractSugar());
    }

    private String stick(){
        return stick.instruction(order.extractStick());
    }

    public boolean containInformationProtocole() {
        return INFORMATION_PROTOCOLE.equals(order.extractDrink());
    }
}
