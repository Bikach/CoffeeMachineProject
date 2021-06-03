package fr.chakib.houd.kata.manufacture.core.domain.extra;

public class Stick {

    private static final String STICK_ABSENT_INSTRUCTION = "therefore no";
    private static final String STICK_PRESENT_INSTRUCTION = "a";

    public String instruction(String stick){
        if(stick.isEmpty())
            return STICK_ABSENT_INSTRUCTION;
        return STICK_PRESENT_INSTRUCTION;
    }

}
