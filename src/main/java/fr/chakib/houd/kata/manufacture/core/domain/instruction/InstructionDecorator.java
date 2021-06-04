package fr.chakib.houd.kata.manufacture.core.domain.instruction;

import fr.chakib.houd.kata.manufacture.core.domain.Order;

public class InstructionDecorator implements Instruction {

    private final Instruction wrapper;

    public InstructionDecorator(Instruction wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String concat(Order order, String message) {
        return wrapper.concat(order, message);
    }
}
