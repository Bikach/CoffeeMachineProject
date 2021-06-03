package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountProtocolException;
import fr.chakib.houd.kata.manufacture.core.domain.message.DrinkInstruction;
import fr.chakib.houd.kata.manufacture.core.domain.message.StickInstruction;
import fr.chakib.houd.kata.manufacture.core.domain.message.SugarInstruction;

public class OrderTranslator {

    private static final String INFORMATION_PROTOCOLE = "M";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private final Order order;

    public OrderTranslator(Order order) {
        this.order = order;
    }

    public String translate(){
        if(containInformationProtocole())
            return DEFAULT_MESSAGE;
        return concatCustomerMessage();
    }

    private String concatCustomerMessage() {
        try {
          return new DrinkInstruction(new SugarInstruction(new StickInstruction())).concat(order, "(Drink maker will make");
        }catch (InsufficientAmountProtocolException e){
            return e.getMessage();
        }
    }

    private boolean containInformationProtocole() {
        return INFORMATION_PROTOCOLE.equals(order.extractDrink());
    }
}
