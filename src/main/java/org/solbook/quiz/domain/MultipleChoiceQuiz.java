package org.solbook.quiz.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class MultipleChoiceQuiz extends Quiz {

    @ElementCollection
    @CollectionTable(name = "multiple_choice_options", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(nullable = false)
    private List<String> options;

    @Column(nullable = false)
    private int answerOption;

    public MultipleChoiceQuiz(String question, QuizType quizType, List<String> options, int answerOption) {
        super(question, quizType);
        this.options = options;
        this.answerOption = answerOption;
    }
}
