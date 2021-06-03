package fr.chakib.houd.kata.manufacture.core.domain.extra;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Sugar {

    private static final String NO_SUGAR_INSTRUCTION = " with no sugar)";

    public String instruction(String numberSugarReceived){
        if(hasAtLeastOneSugar(numberSugarReceived))
            return TranslateSugarNumber.translate(numberSugarReceived);
        return NO_SUGAR_INSTRUCTION;
    }

    private boolean hasAtLeastOneSugar(String number) {
        return !number.isEmpty();
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
            return Stream.of(TranslateSugarNumber.values())
                    .filter(translateSugarNumber -> translateSugarNumber.number.equals(sugarNumber))
                    .map(translateSugarNumber -> translateSugarNumber.instruction)
                    .collect(joining());
        }
    }
}
