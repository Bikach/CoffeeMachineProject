package fr.chakib.houd.kata.manufacture.core.usecase;

import fr.chakib.houd.kata.manufacture.core.domain.OrderTranslator;
import fr.chakib.houd.kata.manufacture.core.domain.port.DrinkMaker;
import fr.chakib.houd.kata.manufacture.core.domain.drink.InsufficientAmountProtocolException;

import static java.lang.String.format;

public class SendTranslatedOrders {

    private static final String CUSTOMER_MESSAGE = "Drink maker makes 1 %s with %s sugar and %s stick";
    private static final String DEFAULT_MESSAGE = "Drink maker forwards any message received onto the coffee machine interface for the customer to see";

    private final OrderTranslator orderTranslator;
    private final DrinkMaker drinkMaker;

    public SendTranslatedOrders(OrderTranslator orderTranslator, DrinkMaker drinkMaker) {
        this.orderTranslator = orderTranslator;
        this.drinkMaker = drinkMaker;
    }

    public String send() {
        if(orderTranslator.containInformationProtocole()){
            drinkMaker.sendOrderTranslated(DEFAULT_MESSAGE);
            return DEFAULT_MESSAGE;
        }
        var order = formatMessageOrder();
        drinkMaker.sendOrderTranslated(order);
        return order;
    }

    private String formatMessageOrder() {
        try {
            return format(CUSTOMER_MESSAGE, orderTranslator.drink(), orderTranslator.sugar(), orderTranslator.stick());
        }catch (InsufficientAmountProtocolException e){
            return e.getMessage();
        }
    }
}
