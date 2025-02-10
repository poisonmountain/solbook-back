package org.solbook.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SubjectiveQuiz extends Quiz {

    @Column(nullable = false)
    private String answer;

    public SubjectiveQuiz(String question, QuizType quizType, String answer) {
        super(question, quizType);
        this.answer = answer;
    }
}
