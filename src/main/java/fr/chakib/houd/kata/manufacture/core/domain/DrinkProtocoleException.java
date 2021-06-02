package fr.chakib.houd.kata.manufacture.core.domain;

public class DrinkProtocoleException extends IllegalArgumentException {
    public DrinkProtocoleException() {
        super("the drink protocol is not supported by the machine.");
    }
}
