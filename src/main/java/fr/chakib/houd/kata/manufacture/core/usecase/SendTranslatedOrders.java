package fr.chakib.houd.kata.manufacture.core.usecase;

import fr.chakib.houd.kata.manufacture.core.domain.OrderTranslator;
import fr.chakib.houd.kata.manufacture.core.domain.port.DrinkMaker;

public class SendTranslatedOrders {

    private final OrderTranslator orderTranslator;
    private final DrinkMaker drinkMaker;

    public SendTranslatedOrders(OrderTranslator orderTranslator, DrinkMaker drinkMaker) {
        this.orderTranslator = orderTranslator;
        this.drinkMaker = drinkMaker;
    }

    public String send() {
        var orderTranslated = orderTranslator.translate();
        drinkMaker.sendOrderTranslated(orderTranslated);
        return orderTranslated;
    }
}
