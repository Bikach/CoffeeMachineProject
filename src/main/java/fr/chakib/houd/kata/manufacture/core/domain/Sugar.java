package fr.chakib.houd.kata.manufacture.core.domain;

import static java.lang.String.valueOf;

public class Sugar {

    private static final String NO_SUGAR_INSTRUCTION = "no";

    public String instruction(String numberReceived){
        var number = Integer.parseInt(numberReceived);
        if(hasAtLeastOneSugar(number))
            return valueOf(number);
        return NO_SUGAR_INSTRUCTION;
    }

    private boolean hasAtLeastOneSugar(int number) {
        return number > 0;
    }
}
