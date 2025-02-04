package org.solbook.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    // BookException
    BOOK_DUPLICATION("해당 책의 정보가 존재합니다.")


    ;
    private final String text;
}
