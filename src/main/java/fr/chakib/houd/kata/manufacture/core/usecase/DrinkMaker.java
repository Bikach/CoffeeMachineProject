package fr.chakib.houd.kata.manufacture.core.usecase;

import fr.chakib.houd.kata.manufacture.core.domain.Protocol;

import static java.lang.String.format;

public class DrinkMaker {

    private static final String CUSTOMER_MESSAGE = "Drink maker makes 1 %s with %s sugar and %s stick";

    private Protocol protocol;

    public void order(Protocol protocol) {
        this.protocol = protocol;
    }

    public String sendInstruction() {
        if(protocol.containInformationProtocole())
            return "Drink maker forwards any message received onto the coffee machine interface for the customer to see";
       return format(CUSTOMER_MESSAGE, protocol.drink(), protocol.sugar(), protocol.stick());
    }
}
