package fr.chakib.houd.kata.manufacture.core.domain.instruction;

import fr.chakib.houd.kata.manufacture.core.domain.Order;

import java.util.stream.Stream;

import static fr.chakib.houd.kata.manufacture.core.domain.instruction.SugarInstruction.TranslateSugarNumber.translate;
import static java.util.stream.Collectors.joining;

public class SugarInstruction implements Instruction {

    private static final String NO_SUGAR_INSTRUCTION = " with no sugar)";

    private final InstructionDecorator instructionDecorator;

    public SugarInstruction(Instruction instruction) {
        this.instructionDecorator = new InstructionDecorator(instruction);
    }

    @Override
    public String concat(Order order, String message) {
        if(hasNotSugar(order.extractSugar()))
            return message + NO_SUGAR_INSTRUCTION;
        return instructionDecorator.concat(order, message + translate(order.extractSugar()));
    }

    private boolean hasNotSugar(String number) {
        return number.isEmpty();
    }

    enum TranslateSugarNumber {

        ONE("1", " with one sugar"),
        TWO("2", " with two sugar");

        private final String number;
        private final String instruction;

        TranslateSugarNumber(String number, String instruction) {
            this.number = number;
            this.instruction = instruction;
        }

        public static String translate(String sugarNumber) {
            return Stream.of(SugarInstruction.TranslateSugarNumber.values())
                    .filter(translateSugarNumber -> translateSugarNumber.number.equals(sugarNumber))
                    .map(translateSugarNumber -> translateSugarNumber.instruction)
                    .collect(joining());
        }
    }
}
