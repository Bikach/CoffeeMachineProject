package fr.chakib.houd.kata.domain.manufacture;

import static java.lang.String.format;

public class DrinkMaker {

    private static final String CUSTOMER_MESSAGE = "Drink maker makes 1 %s with %s sugar and %s stick";

    private Protocole protocole;

    public void order(Protocole protocole) {
        this.protocole = protocole;
    }

    public String sendInstruction() {
        if(protocole.containInformationProtocole())
            return "Drink maker forwards any message received onto the coffee machine interface for the customer to see";
       return format(CUSTOMER_MESSAGE, protocole.drink(), protocole.sugar(), protocole.stick());
    }
}
