package fr.chakib.houd.kata.manufacture.core.domain.drink;

import java.math.BigDecimal;

import static java.lang.String.format;

public class InsufficientAmountException extends IllegalArgumentException {
    public InsufficientAmountException(BigDecimal missingAmount, String drink) {
        super(format("(There are %s cents missing to make one %s)", missingAmount.toString(), drink));
    }
}
