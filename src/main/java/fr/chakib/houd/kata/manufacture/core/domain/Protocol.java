package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.ChocolateDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.CoffeeDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.TeaDrink;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Sugar;

public class Protocol {

    private static final String INFORMATION_PROTOCOLE = "M";

    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();
    private final Sugar sugar = new Sugar();

    private final Order order;

    public Protocol(Order order) {
        this.order = order;
    }

    public String drink() {
        if(tea.validateSelection(order.drink(), order.amount()))
            return tea.instruction();
        if(coffee.validateSelection(order.drink(), order.amount()))
            return coffee.instruction();
        if(chocolate.validateSelection(order.drink(), order.amount())) {
            return chocolate.instruction();
        }
        throw new DrinkProtocoleException();
    }


    public String sugar(){
        return sugar.instruction(order.extractSugar());
    }

    public String stick(){
        return sugar.stickInstruction();
    }

    public boolean containInformationProtocole() {
        return order.drink().equals(INFORMATION_PROTOCOLE);
    }
}
