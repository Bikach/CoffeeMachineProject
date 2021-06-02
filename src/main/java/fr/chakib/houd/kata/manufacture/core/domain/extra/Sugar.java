package fr.chakib.houd.kata.manufacture.core.domain.extra;

import static java.lang.String.valueOf;

public class Sugar {

    private static final String ZERO_SUGAR = "0";
    private static final String NO_SUGAR_INSTRUCTION = "no";
    private final Stick stick = new Stick();
    private int number;

    public String instruction(String numberSugarReceived){
        this.number = formatSugarNUmber(numberSugarReceived);
        if(hasAtLeastOneSugar(number))
            return valueOf(number);
        return NO_SUGAR_INSTRUCTION;
    }

    private int formatSugarNUmber(String numberReceived) {
        var sugarNumber = numberReceived;
        if(sugarNumber.isEmpty() )
            sugarNumber = ZERO_SUGAR;
        return Integer.parseInt(sugarNumber);
    }

    public String stickInstruction() {
        return stick.instruction(number);
    }

    private boolean hasAtLeastOneSugar(int number) {
        return number > 0;
    }
}
