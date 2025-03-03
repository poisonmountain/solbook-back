package org.solbook.quiz.repository.querycustom;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.solbook.quiz.domain.QQuiz;
import org.solbook.quiz.domain.Quiz;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;
@RequiredArgsConstructor
public class QuizRepositoryCustomImpl implements QuizRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    QQuiz quiz = QQuiz.quiz;

    @Override
    public Slice<Quiz> findByBookIdAndKeyword(Long bookId, String keyword, Pageable pageable) {
        String searchKeyword = keyword != null ? keyword.trim() : "";

        List<Quiz> quizzes = queryFactory
                .selectFrom(quiz)
                .where(quiz.book.id.eq(bookId)
                        .and(quiz.question.containsIgnoreCase(searchKeyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = quizzes.size() > pageable.getPageSize();
        if (hasNext) {
            quizzes.remove(quizzes.size() - 1);
        }

        return new SliceImpl<>(quizzes, pageable, hasNext);
    }
}
