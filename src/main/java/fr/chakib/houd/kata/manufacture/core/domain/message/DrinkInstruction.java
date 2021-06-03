package fr.chakib.houd.kata.manufacture.core.domain.message;

import fr.chakib.houd.kata.manufacture.core.domain.Order;
import fr.chakib.houd.kata.manufacture.core.domain.drink.ChocolateDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.CoffeeDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.Drink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.OrangeJuiceDrink;
import fr.chakib.houd.kata.manufacture.core.domain.drink.TeaDrink;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkInstruction implements Instruction {

    private final InstructionDecorator instructionDecorator;

    List<Drink> drinks = Arrays.asList(
            new TeaDrink(),
            new CoffeeDrink(),
            new ChocolateDrink(),
            new OrangeJuiceDrink()
    );

    public DrinkInstruction(Instruction instruction) {
        this.instructionDecorator = new InstructionDecorator(instruction);
    }

    @Override
    public String concat(Order order, String message) {
        var drinkInstruction = drink(order);
        if(drinkInstruction.contains("orange juice"))
            return message + drinkInstruction;
        return instructionDecorator.concat(order, message + drinkInstruction);
    }

    private String drink(Order order) {
        return drinks.stream()
                .filter(drink -> drink.validateSelection(order.extractDrink(), order.amount()))
                .map(Drink::instruction)
                .collect(Collectors.joining());
    }
}
