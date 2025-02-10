package org.solbook.quiz.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SubjectiveQuizRequest(
        @NotNull(message = "BookId는 null 일 수 없습니다.")
        Long bookId,
        @NotBlank(message = "질문은 공백 일 수 없습니다.")
        String question,
        @NotBlank(message = "정답은 공백 일 수 없습니다.")
        String answer
) {
}
