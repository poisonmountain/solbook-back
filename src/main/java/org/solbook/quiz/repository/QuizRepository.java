package org.solbook.quiz.repository;

import org.solbook.quiz.domain.Quiz;
import org.solbook.quiz.repository.querycustom.QuizRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long>, QuizRepositoryCustom {
}
