package org.solbook.quiz.controller.response;

import lombok.Builder;

@Builder
public record QuizSliceResponse(
        Long id,
        String question,
        String quizType
) {
}
