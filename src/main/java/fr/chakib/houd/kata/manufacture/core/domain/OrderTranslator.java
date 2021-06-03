package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.ChocolateDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.CoffeeDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountProtocolException;
import fr.chakib.houd.kata.manufacture.core.domain.drink.OrangeJuiceDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.TeaDrink;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Stick;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Sugar;

public class OrderTranslator {

    private static final String INFORMATION_PROTOCOLE = "M";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private final StringBuilder customerMessage = new StringBuilder("(Drink maker will make");

    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();
    private final OrangeJuiceDrink orangeJuice = new OrangeJuiceDrink();

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
            if (drink().contains("orange juice"))
                return customerMessage.append(drink()).toString();

            return customerMessage
                    .append(drink())
                    .append(sugar())
                    .append(stick())
                    .toString();
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
        else if(orangeJuice.validateSelection(order.extractDrink(), order.amount()))
            instruction = orangeJuice.instruction();
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
