package fr.chakib.houd.kata.manufacture.core.domain.instruction;

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

    private static final String EXTRA_HOT_PROTOCOL = "h";
    private static final String DEFAULT_QUANTITY_INSTRUCTION = " one ";
    private static final String CLOSE_INSTRUCTION = ")";

    private final InstructionDecorator instructionDecorator;

    // Dans un projet Spring j'aurai laissé le framework faire ce travail
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
            return message + DEFAULT_QUANTITY_INSTRUCTION + drinkInstruction + CLOSE_INSTRUCTION;

        drinkInstruction = addDefaultQuantityBeforeInstruction(order, drinkInstruction);

        return instructionDecorator.concat(order, message + drinkInstruction);
    }

    private String drink(Order order) {
        return drinks.stream()
                .filter(drink -> drink.validateSelection(order.extractDrink(), order.amount()))
                .map(Drink::instruction)
                .collect(Collectors.joining());
    }

    private String addDefaultQuantityBeforeInstruction(Order order, String drinkInstruction) {
        if(!order.extractDrink().contains(EXTRA_HOT_PROTOCOL))
            drinkInstruction = DEFAULT_QUANTITY_INSTRUCTION + drinkInstruction;
        return drinkInstruction;
    }
}
