package fr.chakib.houd.kata.manufacture.core.domain;

import fr.chakib.houd.kata.manufacture.core.domain.drink.ChocolateDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.CoffeeDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.TeaDrink;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Stick;
import fr.chakib.houd.kata.manufacture.core.domain.extra.Sugar;

public class OrderTranslator {

    private static final String INFORMATION_PROTOCOLE = "M";

    private final TeaDrink tea = new TeaDrink();
    private final CoffeeDrink coffee = new CoffeeDrink();
    private final ChocolateDrink chocolate = new ChocolateDrink();
    private final Sugar sugar = new Sugar();
    private final Stick stick = new Stick();

    private final Order order;

    public OrderTranslator(Order order) {
        this.order = order;
    }

    public String drink() {
        if(tea.validateSelection(order.extractDrink(), order.amount()))
            return tea.instruction();
        if(coffee.validateSelection(order.extractDrink(), order.amount()))
            return coffee.instruction();
        if(chocolate.validateSelection(order.extractDrink(), order.amount())) {
            return chocolate.instruction();
        }
        throw new DrinkProtocoleException();
    }


    public String sugar(){
        return sugar.instruction(order.extractSugar());
    }

    public String stick(){
        return stick.instruction(order.extractStick());
    }

    public boolean containInformationProtocole() {
        return order.extractDrink().equals(INFORMATION_PROTOCOLE);
    }
}
