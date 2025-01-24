package org.solbook.quiz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class MultipleChoiceQuiz extends Quiz {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String options;

    @Column(nullable = false)
    private int answerOption;
}
