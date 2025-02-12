package org.solbook.common.exception;

public class QuizException extends SolveBookException{
    public QuizException(ExceptionMessage message) {
        super(message.getText());
    }
}
