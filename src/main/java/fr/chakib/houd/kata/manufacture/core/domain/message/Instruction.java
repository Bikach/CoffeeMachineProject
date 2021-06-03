package fr.chakib.houd.kata.manufacture.core.domain.message;

import fr.chakib.houd.kata.manufacture.core.domain.Order;

public interface Instruction {
    String concat(Order order, String message);
}
