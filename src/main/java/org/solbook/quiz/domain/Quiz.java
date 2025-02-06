package org.solbook.quiz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.solbook.book.domain.Book;
import org.solbook.common.auditing.BaseEntity;

@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Entity
public abstract class Quiz extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private QuizType quizType;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
