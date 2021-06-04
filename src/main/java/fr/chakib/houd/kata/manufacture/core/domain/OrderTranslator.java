package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountException;
import fr.chakib.houd.kata.manufacture.core.domain.instruction.DrinkInstruction;
import fr.chakib.houd.kata.manufacture.core.domain.instruction.ExtraHotInstruction;
import fr.chakib.houd.kata.manufacture.core.domain.instruction.StickInstruction;
import fr.chakib.houd.kata.manufacture.core.domain.instruction.SugarInstruction;

public class OrderTranslator {

    private static final String INFORMATION_PROTOCOLE = "M";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";
    public static final String MESSAGE_START = "(Drink maker will make";

    private final Order order;

    public OrderTranslator(Order order) {
        this.order = order;
    }

    public String translate(){
        if(containInformationProtocole())
            return DEFAULT_MESSAGE;
        return concatCustomerInstructions();
    }

    private String concatCustomerInstructions() {
        try {
          return new ExtraHotInstruction(
                    new DrinkInstruction(
                        new SugarInstruction(
                            new StickInstruction()))).concat(order, MESSAGE_START);
        }catch (InsufficientAmountException e){
            return e.getMessage();
        }
    }

    private boolean containInformationProtocole() {
        return INFORMATION_PROTOCOLE.equals(order.extractDrink());
    }
}
