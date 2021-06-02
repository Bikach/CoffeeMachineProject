package fr.chakib.houd.kata.manufacture.core.domain;

import java.math.BigDecimal;

import static java.lang.String.format;

public class InsufficientAmountProtocolException extends IllegalArgumentException {
    public InsufficientAmountProtocolException(BigDecimal missingAmount, String drink) {
        super(format("There are %s cents missing to make a %s.", missingAmount.toString(), drink));
    }
}
