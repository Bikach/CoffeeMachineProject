package fr.chakib.houd.kata.manufacture.core.domain.instruction;

import fr.chakib.houd.kata.manufacture.core.domain.Order;

public class ExtraHotInstruction implements Instruction {

    private static final String EXTRA_HOT_INSTRUCTION = " an extra hot ";
    private static final String EXTRA_HOT_PROTOCOL = "h";

    private final InstructionDecorator instructionDecorator;

    public ExtraHotInstruction(Instruction instruction) {
        this.instructionDecorator = new InstructionDecorator(instruction);
    }

    @Override
    public String concat(Order order, String message) {
        if(order.extractDrink().contains(EXTRA_HOT_PROTOCOL))
            message = message + EXTRA_HOT_INSTRUCTION;
        return instructionDecorator.concat(order, message);
    }
}
