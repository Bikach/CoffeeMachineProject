package fr.chakib.houd.kata.manufacture.core.domain;

public class Stick {

    private static final String STICK_ABSENT_INSTRUCTION = "therefore no";
    private static final String STICK_PRESENT_INSTRUCTION = "a";

    public String instruction(int numberSugar){
        if(hasAtLeastOneSugar(numberSugar))
            return STICK_PRESENT_INSTRUCTION;
        return STICK_ABSENT_INSTRUCTION;
    }

    private boolean hasAtLeastOneSugar(int number) {
        return number > 0;
    }
}
