package fr.chakib.houd.kata.manufacture.unit;

import fr.chakib.houd.kata.manufacture.core.domain.port.DrinkMaker;

public class InMemoryDrinkMaker implements DrinkMaker {

    private String order = "";

    @Override
    public void sendOrderTranslated(String orderTranslated) {
        this.order = orderTranslated;
    }

    public boolean verifyOrderSent(){
        return !order.isEmpty();
    }
}
