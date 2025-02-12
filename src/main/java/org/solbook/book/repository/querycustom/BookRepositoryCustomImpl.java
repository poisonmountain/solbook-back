package org.solbook.book.repository.querycustom;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.solbook.book.domain.Book;
import org.solbook.book.domain.QBook;
import org.solbook.quiz.domain.QQuiz;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

@RequiredArgsConstructor
public class BookRepositoryCustomImpl implements BookRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    QBook book = QBook.book;
    QQuiz quiz = QQuiz.quiz;

    @Override
    public Slice<Book> findByTitleOrAuthorOrderByQuizCount(String keyword, Pageable pageable) {
        String searchKeyword = keyword != null ? keyword.trim() : "";

        List<Book> books = queryFactory
                .selectFrom(book)
                .leftJoin(book.quizzes, quiz)
                .where(book.title.containsIgnoreCase(searchKeyword)
                        .or(book.author.containsIgnoreCase(searchKeyword)))
                .groupBy(book.id)
                .orderBy(Expressions.numberTemplate(Long.class, "count({0})", quiz.id).desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = books.size() > pageable.getPageSize();
        if (hasNext) {
            books.remove(books.size() - 1);
        }

        return new SliceImpl<>(books, pageable, hasNext);
    }
}
