package fr.chakib.houd.kata.manufacture.core.domain.extra;

public class Sugar {

    private static final String NO_SUGAR_INSTRUCTION = "no";

    public String instruction(String numberSugarReceived){
        if(hasAtLeastOneSugar(numberSugarReceived))
            return numberSugarReceived;
        return NO_SUGAR_INSTRUCTION;
    }

    private boolean hasAtLeastOneSugar(String number) {
        return !number.isEmpty();
    }
}
