package fr.chakib.houd.kata.manufacture.core.domain.instruction;

import fr.chakib.houd.kata.manufacture.core.domain.Order;

public class StickInstruction implements Instruction {

    private static final String STICK_PRESENT_INSTRUCTION = " and a stick)";

    @Override
    public String concat(Order order, String message) {
        return message + STICK_PRESENT_INSTRUCTION;
    }
}
