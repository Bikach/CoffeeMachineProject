package fr.chakib.houd.kata.manufacture.core.usecase;

import fr.chakib.houd.kata.manufacture.core.domain.port.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountProtocolException;
import fr.chakib.houd.kata.manufacture.core.domain.Protocol;

import static java.lang.String.format;

public class SendTranslatedOrders {

    private static final String CUSTOMER_MESSAGE = "Drink maker makes 1 %s with %s sugar and %s stick";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private Protocol protocol;
    private final DrinkMaker drinkMaker;

    public SendTranslatedOrders(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void protocolSelected(Protocol protocol) {
        this.protocol = protocol;
    }

    public String sendOrderTranslated() {
        if(protocol.containInformationProtocole()){
            drinkMaker.sendOrderTranslated(DEFAULT_MESSAGE);
            return DEFAULT_MESSAGE;
        }
        var order = formatInstructions();
        drinkMaker.sendOrderTranslated(order);
        return order;
    }

    private String formatInstructions() {
        try {
            return format(CUSTOMER_MESSAGE, protocol.drink(), protocol.sugar(), protocol.stick());
        }catch (InsufficientAmountProtocolException e){
            return e.getMessage();
        }
    }
}
