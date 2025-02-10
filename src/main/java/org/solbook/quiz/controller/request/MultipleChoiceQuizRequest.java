package org.solbook.quiz.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MultipleChoiceQuizRequest(
        @NotNull(message = "BookId는 null 일 수 없습니다.")
        Long bookId,
        @NotBlank(message = "질문은 공백 일 수 없습니다.")
        String question,
        @NotNull(message = "선택지는 null 일 수 없습니다.")
        List<String> options,
        @NotNull(message = "정답은 null 일 수 없습니다.")
        int answerOption
) {
}
