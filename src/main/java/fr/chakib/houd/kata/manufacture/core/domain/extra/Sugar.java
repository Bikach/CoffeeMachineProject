package fr.chakib.houd.kata.manufacture.core.domain.extra;

import static java.lang.String.valueOf;

public class Sugar {

    private static final String NO_SUGAR_INSTRUCTION = "no";
    private final Stick stick = new Stick();
    private int number;

    public String instruction(String numberReceived){
        this.number = Integer.parseInt(numberReceived);
        if(hasAtLeastOneSugar(number))
            return valueOf(number);
        return NO_SUGAR_INSTRUCTION;
    }

    public String stickInstruction() {
        return stick.instruction(number);
    }

    private boolean hasAtLeastOneSugar(int number) {
        return number > 0;
    }
}
