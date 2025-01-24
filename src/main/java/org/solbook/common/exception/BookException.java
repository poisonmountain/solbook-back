package org.solbook.common.exception;

public class BookException extends SolveBookException {
    public BookException(ExceptionMessage message) {
        super(message.getText());
    }
}
