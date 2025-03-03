package org.solbook.quiz.repository.querycustom;

import org.solbook.quiz.domain.Quiz;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface QuizRepositoryCustom {
    Slice<Quiz> findByBookIdAndKeyword(Long bookId, String keyword, Pageable pageable);
}
