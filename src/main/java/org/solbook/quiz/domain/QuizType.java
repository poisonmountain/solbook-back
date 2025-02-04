package org.solbook.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuizType {
    SUBJECTIVE("주관식"),
    MULTIPLE_CHOICE("객관식");

    private final String description;
}