package org.solbook.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    // BookException
    BOOK_DUPLICATION("해당 책의 정보가 존재합니다."),

    BOOK_NOT_FOUND("해당 책을 찾을 수 없습니다."),

    // QuizException
    QUIZ_NOT_FOUND("해당 퀴즈를 찾을 수 없습니다."),

    UNKNOWN_QUIZ_TYPE("해당 퀴즈의 타입을 알 수 없습니다.");
    private final String text;
}
