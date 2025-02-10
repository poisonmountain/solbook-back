package org.solbook.quiz.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record QuizResponse(
        String question,
        String quizType,
        List<String> options,
        String answer
) {

}
