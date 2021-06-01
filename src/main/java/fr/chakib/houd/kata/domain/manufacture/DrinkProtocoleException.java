package fr.chakib.houd.kata.domain.manufacture;

public class DrinkProtocoleException extends IllegalArgumentException {
    public DrinkProtocoleException() {
        super("the drink protocol is not supported by the machine.");
    }
}
